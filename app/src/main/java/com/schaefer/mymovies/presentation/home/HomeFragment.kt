package com.schaefer.mymovies.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.schaefer.mymovies.R
import com.schaefer.mymovies.presentation.adapters.home.HomeListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.*
import timber.log.Timber

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val homeViewModel: HomeViewModel by viewModels()
    private val homeShowAdapter = HomeListAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.getShows()
        rvHomeShows.adapter = homeShowAdapter
        setupObservers()
    }

    private fun setupObservers() {
        homeViewModel.state.observe(viewLifecycleOwner, {
            Timber.d("State changed")
        })

        homeViewModel.listShow.observe(viewLifecycleOwner, {
            homeShowAdapter.shows = it
        })
    }
}