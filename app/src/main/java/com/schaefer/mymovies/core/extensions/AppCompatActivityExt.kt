package com.schaefer.mymovies.core.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
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

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}