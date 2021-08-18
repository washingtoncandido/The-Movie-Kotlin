package com.example.searchgoogle.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(

    @SerializedName("original_title")
    val originalTitle: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName( "original_language")
    val legendOriginal: String?,

):Parcelable{
    constructor(): this("","","","")
}
