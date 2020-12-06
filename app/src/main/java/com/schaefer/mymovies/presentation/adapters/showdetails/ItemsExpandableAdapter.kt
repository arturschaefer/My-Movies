package com.schaefer.mymovies.presentation.adapters.showdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.schaefer.mymovies.R
import com.schaefer.mymovies.presentation.model.Episode
import com.schaefer.mymovies.presentation.model.EpisodeGroup
import kotlinx.android.synthetic.main.item_episode_content.view.*
import kotlinx.android.synthetic.main.item_episode_header.view.*
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

private const val VIEW_TYPE_ITEM = 1
private const val VIEW_TYPE_HEADER = 2

private const val IC_EXPANDED_ROTATION_DEG = 0F
private const val IC_COLLAPSED_ROTATION_DEG = 180F

//Reference: https://medium.com/codeshake/create-an-expandable-recyclerview-with-the-mergeadapter-254fd671fa5b
class ItemsExpandableAdapter(private val episodesGroup: EpisodeGroup) :
    RecyclerView.Adapter<ItemsExpandableAdapter.ViewHolder>() {

    var isExpanded: Boolean by Delegates.observable(false) { _: KProperty<*>, _: Boolean, newExpandedValue: Boolean ->
        if (newExpandedValue) {
            notifyItemRangeInserted(1, episodesGroup.listEpisodes.size)
            //To update the header expand icon
            notifyItemChanged(0)
        } else {
            notifyItemRangeRemoved(1, episodesGroup.listEpisodes.size)
            //To update the header expand icon
            notifyItemChanged(0)
        }
    }

    private val onHeaderClickListener = View.OnClickListener {
        isExpanded = !isExpanded
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_HEADER else VIEW_TYPE_ITEM
    }

    override fun getItemCount(): Int = if (isExpanded) episodesGroup.listEpisodes.size + 1 else 1


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_HEADER -> ViewHolder.HeaderVH(
                inflater.inflate(
                    R.layout.item_episode_header,
                    parent,
                    false
                )
            )
            else -> ViewHolder.ItemVH(
                inflater.inflate(
                    R.layout.item_episode_content,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder.ItemVH -> holder.bind(episodesGroup.listEpisodes[position - 1])
            is ViewHolder.HeaderVH -> {
                holder.bind(episodesGroup.title, isExpanded, onHeaderClickListener)
            }
        }
    }

    sealed class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        class ItemVH(itemView: View) : ViewHolder(itemView) {

            fun bind(content: Episode) {
                itemView.apply {
                    tvItemContent.text = content.name.orEmpty()
                }
            }
        }

        class HeaderVH(itemView: View) : ViewHolder(itemView) {
            internal val tvTitle = itemView.tvTitle
            internal val icExpand = itemView.icExpand

            fun bind(content: String, expanded: Boolean, onClickListener: View.OnClickListener) {
                tvTitle.text = content
                icExpand.rotation =
                    if (expanded) IC_EXPANDED_ROTATION_DEG else IC_COLLAPSED_ROTATION_DEG
                itemView.setOnClickListener(onClickListener)
            }
        }
    }
}