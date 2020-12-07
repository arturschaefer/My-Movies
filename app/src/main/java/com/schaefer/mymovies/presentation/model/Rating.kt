package com.schaefer.mymovies.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Rating (
	val average : Double
): Parcelable {
	fun hasValue(): Boolean = average > 0.0
}