package com.schaefer.mymovies.presentation.adapters.show

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.schaefer.mymovies.R
import com.schaefer.mymovies.presentation.model.Show
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_card_image.*

class ShowListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView), LayoutContainer {

    fun bind(show: Show, itemClickListener: OnItemClickListener) {
        tvItemShowName.text = show.name

        Glide.with(itemView).load(show.image?.original).centerCrop()
            .placeholder(R.drawable.show_placeholder).into(ivItemPoster)

        itemView.setOnClickListener { itemClickListener.onItemClick(show) }
    }

    override val containerView: View
        get() = itemView
}