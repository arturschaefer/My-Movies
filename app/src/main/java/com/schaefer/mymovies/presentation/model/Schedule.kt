package com.schaefer.mymovies.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Schedule (
	val time : String,
	val days : List<String>
): Parcelable