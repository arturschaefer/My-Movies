package com.schaefer.mymovies.presentation.screens.search

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.schaefer.mymovies.R
import com.schaefer.mymovies.presentation.adapters.show.OnItemClickListener
import com.schaefer.mymovies.presentation.adapters.show.ShowListAdapter
import com.schaefer.mymovies.presentation.model.Show
import com.schaefer.mymovies.presentation.screens.details.DetailsActivity
import com.schaefer.mymovies.presentation.screens.details.show.ShowDetailsFragment.Companion.BUNDLE_SHOW
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_search.*

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search), OnItemClickListener {
    private val searchViewModel: SearchViewModel by activityViewModels()

    private val searchShowAdapter = ShowListAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        setupView()
    }

    private fun setupObservers() {
        searchViewModel.state.observe(viewLifecycleOwner, {
            pbSearch.isVisible = it.isLoadingEnabled
            lavEmpty.isVisible = it.isEmpty
        })

        searchViewModel.listShow.observe(viewLifecycleOwner, {
            searchShowAdapter.shows = it
        })

        searchViewModel.action.observe(viewLifecycleOwner, {
            when (it) {
                is SearchAction.NavigateToDetails -> {
                    startActivity(
                        Intent(context, DetailsActivity::class.java).putExtra(
                            BUNDLE_SHOW,
                            it.show
                        )
                    )
                }
            }
        })
    }

    private fun setupView() {
        rvSearch.apply {
            adapter = searchShowAdapter
        }
    }


    override fun onItemClick(show: Show) {
        searchViewModel.navigateToDetails(show)
    }
}