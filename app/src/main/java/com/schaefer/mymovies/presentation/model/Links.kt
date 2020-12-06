package com.schaefer.mymovies.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Links (
	val self : Self?,
	val previousEpisode : PreviousEpisode?
): Parcelable