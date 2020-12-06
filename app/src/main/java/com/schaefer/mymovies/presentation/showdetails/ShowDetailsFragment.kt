package com.schaefer.mymovies.presentation.showdetails

import android.os.Bundle
import android.view.View
import androidx.core.text.parseAsHtml
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.schaefer.mymovies.R
import com.schaefer.mymovies.presentation.model.Show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.content_details.view.*
import kotlinx.android.synthetic.main.fragment_show_details.*
import timber.log.Timber

@AndroidEntryPoint
class ShowDetailsFragment : Fragment(R.layout.fragment_show_details) {

    val args by navArgs<ShowDetailsFragmentArgs>()

    private val show: Show by lazy {
        ShowDetailsFragmentArgs.fromBundle(
            requireActivity().intent.extras ?: Bundle()
        ).show
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.d(show.toString())
        setupView()
    }

    private fun setupView() {
        includeShowDetails.apply {
            tvScheduleDaysDescription.text = show.schedule?.days.toString()
            tvScheduleTimeDescription.text = show.schedule?.time
            tvGenreList.text = show.genres.toString()
            tvSummaryDescription.text = show.summary.parseAsHtml()
        }
    }
}
