package com.schaefer.mymovies.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.schaefer.mymovies.R
import com.schaefer.mymovies.presentation.adapters.home.HomeListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val homeViewModel: HomeViewModel by viewModels()
    private val homeShowAdapter = HomeListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getShows()
        setupView()
        setupObservers()
    }

    private fun setupView() {
        rvHomeShows.apply {
            adapter = homeShowAdapter
        }

        srlHomeFragment.setOnRefreshListener { homeViewModel.getShows() }
    }

    private fun setupObservers() {
        homeViewModel.state.observe(viewLifecycleOwner, {
            srlHomeFragment.isRefreshing = it.isLoading
        })

        homeViewModel.listShow.observe(viewLifecycleOwner, {
            homeShowAdapter.shows = it
        })
    }
}