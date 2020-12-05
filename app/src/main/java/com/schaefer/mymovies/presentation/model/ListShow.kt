package com.schaefer.mymovies.presentation.model

data class ListShow(val listShow: List<Show>) {
    fun size(): Int = listShow.size
}