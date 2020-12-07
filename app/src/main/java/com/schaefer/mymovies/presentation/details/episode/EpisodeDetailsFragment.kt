package com.schaefer.mymovies.presentation.details.episode

import android.os.Bundle
import android.view.View
import androidx.core.text.parseAsHtml
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.schaefer.mymovies.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.content_episode_details.*

@AndroidEntryPoint
class EpisodeDetailsFragment : Fragment(R.layout.fragment_episode_details) {
    private val episodeDetailsViewModel: EpisodeDetailsViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        episodeDetailsViewModel.episode?.let { episode ->
            tvEpisodeNumberDescription.text = episode.number.toString()
            tvEpisodeSeasonDescription.text = episode.season.toString()
            tvEpisodeSummaryDescription.text = episode.summary?.parseAsHtml()
        }
    }
}