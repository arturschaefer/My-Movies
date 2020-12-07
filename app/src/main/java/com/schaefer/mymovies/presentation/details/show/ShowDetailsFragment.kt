package com.schaefer.mymovies.presentation.details.show

import android.os.Bundle
import android.view.View
import androidx.core.text.parseAsHtml
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.schaefer.mymovies.R
import com.schaefer.mymovies.presentation.adapters.showdetails.ExpandableItemAnimator
import com.schaefer.mymovies.presentation.adapters.showdetails.ItemsExpandableAdapter
import com.schaefer.mymovies.presentation.adapters.showdetails.OnItemClickListener
import com.schaefer.mymovies.presentation.model.Episode
import com.schaefer.mymovies.presentation.model.EpisodeGroup
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.content_show_details.*

@AndroidEntryPoint
class ShowDetailsFragment : Fragment(R.layout.fragment_show_details), OnItemClickListener {
    private val viewModel: ShowDetailsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.episodes.observe(viewLifecycleOwner, { mapGroupBySeason ->
            setupConcatAdapter(mapGroupBySeason)
        })
    }

    private fun setupConcatAdapter(mapGroupBySeason: Map<Int?, List<Episode>>) {
        val expandableAdapter = mapGroupBySeason.map {
            ItemsExpandableAdapter(
                EpisodeGroup(
                    "Season ${it.key}",
                    it.value
                ),
                this
            )
        }

        val concatAdapterConfig = ConcatAdapter.Config.Builder()
            .setIsolateViewTypes(false)
            .build()
        val concatAdapter = ConcatAdapter(concatAdapterConfig, expandableAdapter)
        with(rvSeasons) {
            layoutManager = LinearLayoutManager(context).apply {
                addItemDecoration(DividerItemDecoration(context, this.orientation))
            }
            itemAnimator = ExpandableItemAnimator()
            adapter = concatAdapter
        }
    }

    private fun setupView() {
        viewModel.show?.let {
            tvScheduleDaysDescription.text = it.schedule?.days?.joinToString(separator = ", ")
            tvScheduleTimeDescription.text = it.schedule?.time
            tvGenreList.text = it.genres.joinToString(separator = ", ")
            tvSummaryDescription.text = it.summary.parseAsHtml()
            viewModel.getEpisodeList(it.id)
        }
    }

    override fun onItemClick(episode: Episode) {
        viewModel.navigateToEpisodeDetails(episode)
    }
}
