package com.schaefer.mymovies.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Country(
    val name: String,
    val code: String,
    val timezone: String
): Parcelable