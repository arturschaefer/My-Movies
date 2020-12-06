package com.schaefer.mymovies.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Externals (
	val tvrage : Int,
	val thetvdb : Int,
	val imdb : String
): Parcelable