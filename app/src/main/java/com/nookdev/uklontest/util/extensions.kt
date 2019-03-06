package com.nookdev.uklontest.util

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.nookdev.uklontest.R

inline fun <reified T : ViewModel> FragmentActivity.injectViewModel(
    factory: ViewModelProvider.Factory
): T {
    return ViewModelProviders.of(this, factory)[T::class.java]
}

inline fun <reified T : ViewModel> Fragment.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProviders.of(this, factory)[T::class.java]
}

fun inflate(parent: ViewGroup, @LayoutRes resId: Int): View {
    return LayoutInflater.from(parent.context).inflate(resId, parent, false)
}

fun Fragment.showToast(@StringRes resId: Int, duration: Int = Toast.LENGTH_SHORT) {
    activity?.let {
        Toast.makeText(it, resId, duration).show()
    }
}

fun Fragment.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    activity?.let {
        Toast.makeText(it, text, duration).show()
    }
}

fun NavController.navigateTo(
    @IdRes destination: Int, args: Bundle? = null,
    navOptions: NavOptions? = null
) {
    if (currentDestination?.id == destination) return
    navigate(destination, args, navOptions ?: buildDefaultNavOptions())
}

fun buildDefaultNavOptions() = defaultNavOptionsBuilder().build()

fun defaultNavOptionsBuilder(
    singleTop: Boolean = true,
    @IdRes popUpTo: Int = R.id.postsFragment,
    popUpInclusive: Boolean = false
): NavOptions.Builder = NavOptions.Builder()
    .setLaunchSingleTop(singleTop)
    .setPopUpTo(popUpTo, popUpInclusive)
    .setEnterAnim(R.anim.nav_default_enter_anim)
    .setExitAnim(R.anim.nav_default_exit_anim)
    .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
    .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
