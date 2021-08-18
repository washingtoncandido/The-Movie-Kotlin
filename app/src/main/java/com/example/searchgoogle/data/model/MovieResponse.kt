package com.example.searchgoogle.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class MovieResponse(
    @SerializedName("results")
    val movies:List<Result>
):Parcelable{
  constructor():this(mutableListOf())
}



