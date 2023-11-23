package com.powersoft.coffeeapp.domain.model

import android.os.Parcel
import android.os.Parcelable

data class Coffee(
    val coffeeName: String,
    val extraItem: String,
    val rating: Float,
    val coffeeImage: Int,
    val price: Float
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(coffeeName)
        parcel.writeString(extraItem)
        parcel.writeFloat(rating)
        parcel.writeInt(coffeeImage)
        parcel.writeFloat(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coffee> {
        override fun createFromParcel(parcel: Parcel): Coffee {
            return Coffee(parcel)
        }

        override fun newArray(size: Int): Array<Coffee?> {
            return arrayOfNulls(size)
        }
    }
}