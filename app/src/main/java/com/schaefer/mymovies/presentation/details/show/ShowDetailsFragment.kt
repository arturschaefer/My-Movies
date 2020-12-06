package com.schaefer.mymovies.presentation.details.show

import android.os.Bundle
import android.view.View
import androidx.core.text.parseAsHtml
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.schaefer.mymovies.R
import com.schaefer.mymovies.presentation.adapters.showdetails.ExpandableItemAnimator
import com.schaefer.mymovies.presentation.adapters.showdetails.ItemsExpandableAdapter
import com.schaefer.mymovies.presentation.adapters.showdetails.OnItemClickListener
import com.schaefer.mymovies.presentation.details.episode.EpisodeDetailsFragment
import com.schaefer.mymovies.presentation.model.Episode
import com.schaefer.mymovies.presentation.model.EpisodeGroup
import com.schaefer.mymovies.presentation.model.Show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.content_show_details.*
import kotlinx.android.synthetic.main.fragment_show_details.*
import timber.log.Timber

@AndroidEntryPoint
class ShowDetailsFragment : Fragment(R.layout.fragment_show_details), OnItemClickListener {
    private val viewModel: ShowDetailsViewModel by viewModels()

    val args by navArgs<ShowDetailsFragmentArgs>()

    private val show: Show by lazy {
        ShowDetailsFragmentArgs.fromBundle(
            requireActivity().intent.extras ?: Bundle()
        ).show
    }

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
        includeShowDetails.apply {
            tvScheduleDaysDescription.text = show.schedule?.days.toString()
            tvScheduleTimeDescription.text = show.schedule?.time
            tvGenreList.text = show.genres.toString()
            tvSummaryDescription.text = show.summary.parseAsHtml()
        }
        viewModel.getEpisodeList(show.id)
    }

    override fun onItemClick(show: Episode) {
        Timber.d(show.toString())
        activity?.supportFragmentManager?.beginTransaction()
            ?.add(R.id.nav_host_fragment, EpisodeDetailsFragment(), "EpisodeDetails")
    }
}
