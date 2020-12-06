package com.schaefer.mymovies.presentation.showdetails

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.bumptech.glide.Glide
import com.schaefer.mymovies.R
import com.schaefer.mymovies.presentation.model.Show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_details.*

const val BUNDLE_SHOW = "show"

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity(R.layout.activity_details) {
    private val show: Show? by lazy {
        intent.extras?.getParcelable(BUNDLE_SHOW) as Show?
    }

    private val navController: NavController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupToolbar()
        setupNavController()
    }

    private fun setupNavController() {
        navController.navigate(
            R.id.showDetailsFragment,
            bundleOf(BUNDLE_SHOW to show)
        )
        setupActionBarWithNavController(navController, AppBarConfiguration.Builder().build())
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbarDetails)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        ctlToolbar.apply {
            title = show?.name
            Glide.with(context)
                .load(show?.image?.original)
                .placeholder(R.drawable.show_placeholder)
                .into(ivCollapsingToolbar)
            setCollapsedTitleTextAppearance(R.style.coll_toolbar_title)
            setExpandedTitleTextAppearance(R.style.exp_toolbar_title)
            //TODO set color based on image background
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        if (!(navController.navigateUp() || super.onSupportNavigateUp())) {
            finish()
        } else {
            onBackPressed()
        }
        return true
    }
}