package com.rmn.moviecatalogue

import android.os.Parcel
import android.os.Parcelable

data class Movie(
    var moviePoster: Int,
    var movieTitle: String,
    var moviedescription: String,
    var movieGenre: String,
    var movieDuration: String,
    var movieDirector: String,
    var movieRating: String) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(moviePoster)
        parcel.writeString(movieTitle)
        parcel.writeString(moviedescription)
        parcel.writeString(movieGenre)
        parcel.writeString(movieDuration)
        parcel.writeString(movieDirector)
        parcel.writeString(movieRating)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}