package com.example.exo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: ListViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val words = arrayListOf<Mot>(
            Mot("Starling","   Noun,a common bird with black or dark brown feathers that lives in large groups in many parts of the world",R.drawable.starling,R.raw.starling,null),
            Mot("Mango","   Noun,an oval tropical fruit with a smooth skin, orange-yellow flesh, and a large, hard seed in the middle picture of mango",R.drawable.mango,R.raw.mango,R.raw.mango_video),
            Mot("Gold","   Noun,a yellow precious metal, the chemical element of atomic number 79, used especially in jewellery and decoration and to guarantee the value of currencies",R.drawable.gold,R.raw.gold,null)
        )

        adapter = ListViewAdapter(this,words)
        listeMots.adapter = adapter
        listeMots.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DisplayInfoWord::class.java)
            intent.putExtra("word",words[position])
            startActivity(intent)
        }
    }
}
