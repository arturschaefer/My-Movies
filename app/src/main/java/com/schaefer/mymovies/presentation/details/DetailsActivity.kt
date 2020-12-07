package com.schaefer.mymovies.presentation.details

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.schaefer.mymovies.R
import com.schaefer.mymovies.core.extensions.addFragment
import com.schaefer.mymovies.core.extensions.replaceFragment
import com.schaefer.mymovies.presentation.details.episode.EpisodeDetailsFragment
import com.schaefer.mymovies.presentation.details.episode.EpisodeDetailsViewModel
import com.schaefer.mymovies.presentation.details.show.ShowDetailsFragment
import com.schaefer.mymovies.presentation.details.show.ShowDetailsViewModel
import com.schaefer.mymovies.presentation.model.Image
import com.schaefer.mymovies.presentation.model.Show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_details.*

const val BUNDLE_SHOW = "show"

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity(R.layout.activity_details) {
    private val showDetailsViewModel: ShowDetailsViewModel by viewModels()
    private val episodeViewModel: EpisodeDetailsViewModel by viewModels()
    lateinit var onBackPressedAction: () -> Unit

    private val showBundle: Show? by lazy {
        intent.extras?.getParcelable(BUNDLE_SHOW) as Show?
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupObservers()

        setupDefaultToolbar()

        showDetailsViewModel.apply {
            show = showBundle
            navigateToShowDetails()
        }
    }

    private fun setupDefaultToolbar() {
        setSupportActionBar(toolbarDetails)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbarDetails.setNavigationOnClickListener {
            onBackPressedAction()
        }
    }

    private fun setupObservers() {
        showDetailsViewModel.action.observe(this, { detailsAction ->
            handleAction(detailsAction)
        })

        episodeViewModel.action.observe(this, { detailsAction ->
            handleAction(detailsAction)
        })
    }

    private fun handleAction(detailsAction: DetailsAction?) {
        when (detailsAction) {
            is DetailsAction.NavigateToShowDetails -> {
                showDetailsViewModel.show?.let { show ->
                    replaceFragment(ShowDetailsFragment(), R.id.idDetailsFragment)
                    setupUiToolbar(show.name, show.image) { finish() }
                }
            }
            is DetailsAction.NavigateToEpisodeDetails -> {
                episodeViewModel.episode = detailsAction.episode
                episodeViewModel.episode?.let { episode ->
                    addFragment(EpisodeDetailsFragment(), R.id.idDetailsFragment)
                    setupUiToolbar(
                        episode.name.orEmpty(),
                        episode.image
                    ) {
                        episodeViewModel.navigateToShowDetails()
                    }
                }

            }
        }
    }

    private fun setupUiToolbar(titleToolbar: String, image: Image?, action: () -> Unit) {
        ctlToolbar.apply {
            title = titleToolbar
            Glide.with(context)
                .load(image?.original)
                .centerCrop()
                .placeholder(R.drawable.show_placeholder)
                .into(ivCollapsingToolbar)
            setCollapsedTitleTextAppearance(R.style.coll_toolbar_title)
            setExpandedTitleTextAppearance(R.style.exp_toolbar_title)
            //TODO set color based on image background
        }

        onBackPressedAction = action
    }

    override fun onBackPressed() {
        onBackPressedAction()
    }
}