package com.ex.recyclerview

import android.os.Parcel
import android.os.Parcelable

data class Estado (

    val nome: String,
    val capital: String,
    val populacao: String,
    val regiao: String,
    val bandeira: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeString(capital)
        parcel.writeString(populacao)
        parcel.writeString(regiao)
        parcel.writeInt(bandeira)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Estado> {
        override fun createFromParcel(parcel: Parcel): Estado {
            return Estado(parcel)
        }

        override fun newArray(size: Int): Array<Estado?> {
            return arrayOfNulls(size)
        }
    }
}