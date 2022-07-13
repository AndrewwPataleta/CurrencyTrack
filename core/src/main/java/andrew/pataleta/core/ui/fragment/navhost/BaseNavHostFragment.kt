package ru.patstudio.core.ui.fragment.navhost

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment


class BaseNavHostFragment: NavHostFragment() {

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    companion object {

        private const val KEY_GRAPH_ID = "android-support-nav:fragment:graphId"
        private const val KEY_START_DESTINATION_ARGS =
            "android-support-nav:fragment:startDestinationArgs"

        @JvmStatic
        fun createNavHostFragment(
            @NavigationRes graphResId: Int,
            startDestinationArgs: Bundle? = null
        ): BaseNavHostFragment {

            val bundle: Bundle = Bundle().apply {
                putInt(KEY_GRAPH_ID, graphResId)

                if (startDestinationArgs != null) {
                    putBundle(KEY_START_DESTINATION_ARGS, startDestinationArgs)
                }
            }

            return BaseNavHostFragment().apply {
                arguments = bundle
            }
        }
    }

}