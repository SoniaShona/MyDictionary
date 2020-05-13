package com.example.exo1

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import kotlinx.android.synthetic.main.activity_display_info_word.*

class DisplayInfoWord : AppCompatActivity() {

    private var mp: MediaPlayer? = null
    private var mc: MediaController? = null
    private var resId:Int = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_info_word)

        val word = intent.getParcelableExtra<Mot>("word")
        mot.text = word.nom
        definition.text = word.definition
        imgWorld.setImageResource(word.image)
        resId = word.audio
        btnPlayAudio.setOnClickListener { lireAudio(resId) }
        if (word.video!=null){
            videoView.visibility = View.VISIBLE
            lireVideo(word.video)
        }

    }

    fun lireAudio(resId: Int) {
        if (mp == null) {        //set up MediaPlayer
            mp = MediaPlayer.create(this, resId)

            try {
                mp!!.prepare()

            } catch (e: Exception) {
                e.printStackTrace()
            }

        }
        if (!mp!!.isPlaying())
            mp!!.start()
        else
            mp!!.pause()
    }

    private fun lireVideo(resId: Int) {
        val vv = videoView
        if (mc == null) {

            mc = MediaController(this)
            vv.setMediaController(mc)
            val video = Uri.parse("android.resource://" + this?.packageName + "/"
                    + resId) //do not add any extension
            vv.setVideoURI(video)
            vv.start()
        } else {
            if (!vv.isPlaying) {
                vv.start()

            } else {
                vv.pause()
            }
        }
    }
}
