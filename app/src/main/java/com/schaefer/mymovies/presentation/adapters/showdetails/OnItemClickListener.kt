package com.schaefer.mymovies.presentation.adapters.showdetails

import com.schaefer.mymovies.presentation.model.Episode

interface OnItemClickListener {
    fun onItemClick(show: Episode)
}