package com.schaefer.mymovies.presentation.screens.search

import android.app.SearchManager
import android.view.Menu
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import com.schaefer.mymovies.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SearchActivity: AppCompatActivity(R.layout.activity_search){
    val searchViewModel: SearchViewModel by viewModels()

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_search, menu)

        val manager = getSystemService(SEARCH_SERVICE) as SearchManager
        val searchItem = menu?.findItem(R.id.menu_action_search)
        val searchView = searchItem?.actionView as SearchView

        searchView.setSearchableInfo(manager.getSearchableInfo(componentName))

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchView.onActionViewCollapsed()
                searchViewModel.getShowsBySearch(query?.trim())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        return true
    }
}