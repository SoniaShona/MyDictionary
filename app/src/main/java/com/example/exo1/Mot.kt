package com.example.exo1

import android.os.Parcel
import android.os.Parcelable


data class Mot(
    val nom: String?,
    val definition: String?,
    val image:Int = R.mipmap.ic_launcher,
    val audio: Int = R.raw.mango,
    val video: Int? = null
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nom)
        parcel.writeString(definition)
        parcel.writeInt(image)
        parcel.writeInt(audio)
        parcel.writeValue(video)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Mot> {
        override fun createFromParcel(parcel: Parcel): Mot {
            return Mot(parcel)
        }

        override fun newArray(size: Int): Array<Mot?> {
            return arrayOfNulls(size)
        }
    }
}