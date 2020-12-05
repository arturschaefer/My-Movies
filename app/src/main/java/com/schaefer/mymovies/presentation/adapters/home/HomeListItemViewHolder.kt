package com.schaefer.mymovies.presentation.adapters.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_card_image.*
import com.schaefer.mymovies.presentation.model.Show
import kotlinx.android.extensions.LayoutContainer

class HomeListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    fun bind(show: Show) {
        tvItemShowName.text = show.name
        tvItemRate.text = show.rating.average

        Glide.with(itemView).load(show.image.original).centerCrop().into(ivItemPoster)
    }

    override val containerView: View
        get() = itemView
}