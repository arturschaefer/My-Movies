package com.schaefer.mymovies.presentation.screens.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.schaefer.mymovies.R
import com.schaefer.mymovies.core.PaginationScrollListener
import com.schaefer.mymovies.presentation.adapters.show.OnItemClickListener
import com.schaefer.mymovies.presentation.adapters.show.ShowListAdapter
import com.schaefer.mymovies.presentation.model.Show
import com.schaefer.mymovies.presentation.screens.details.DetailsActivity
import com.schaefer.mymovies.presentation.screens.details.show.ShowDetailsFragment.Companion.BUNDLE_SHOW
import com.schaefer.mymovies.presentation.screens.search.SearchActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), OnItemClickListener {
    private val homeViewModel: HomeViewModel by viewModels()
    private val homeShowAdapter = ShowListAdapter(this)
    var isLastPage: Boolean = false
    var isLoading: Boolean = false
    var page = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        homeViewModel.getShows()
        setupView()
        setupObservers()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_home, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_action_open_search -> {
                homeViewModel.navigateToSearch()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupView() {
        rvHomeShows.apply {
            adapter = homeShowAdapter
            addOnScrollListener(object : PaginationScrollListener(GridLayoutManager(context, 2)) {
                override fun isLastPage(): Boolean {
                    return isLastPage
                }

                override fun isLoading(): Boolean {
                    return isLoading
                }

                override fun loadMoreItems() {
                    isLoading = true
                    homeViewModel.getShows(++page)
                }
            })
        }

        srlHomeFragment.setOnRefreshListener { homeViewModel.getShows() }
    }

    private fun setupObservers() {
        homeViewModel.state.observe(viewLifecycleOwner, {
            srlHomeFragment.isRefreshing = it.isLoading
        })

        homeViewModel.listShow.observe(viewLifecycleOwner, {
            homeShowAdapter.shows = it
            isLoading = false
        })

        homeViewModel.action.observe(viewLifecycleOwner, {
            when (it) {
                is HomeAction.NavigateToDetails -> {
                    startActivity(
                        Intent(context, DetailsActivity::class.java).putExtra(
                            BUNDLE_SHOW,
                            it.show
                        )
                    )
                }
                is HomeAction.NavigateToSearch -> {
                    startActivity(Intent(context, SearchActivity::class.java))
                }
            }
        })
    }

    override fun onItemClick(show: Show) {
        homeViewModel.navigateToDetails(show)
    }
}