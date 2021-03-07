package com.schaefer.mymovies.core.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlin.random.Random

//Reference: https://stackoverflow.com/questions/31090488/how-to-replace-a-framelayout-with-a-fragment-with-kotlin-on-android
fun AppCompatActivity.addFragment(
    fragment: Fragment,
    frameId: Int,
    tag: String = Random.nextInt().toString()
) {
    supportFragmentManager.beginTransaction().add(frameId, fragment).addToBackStack(tag).commit()
}

fun AppCompatActivity.replaceFragment(fragment: Fragment, frameId: Int) {
    supportFragmentManager.inTransaction { replace(frameId, fragment) }
}
