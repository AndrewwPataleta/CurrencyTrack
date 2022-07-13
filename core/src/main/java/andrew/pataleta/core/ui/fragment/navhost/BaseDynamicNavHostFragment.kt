package andrew.pataleta.core.ui.fragment.navhost

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.dynamicfeatures.fragment.DynamicNavHostFragment

class BaseDynamicNavHostFragment : DynamicNavHostFragment() {

    companion object {

        private const val KEY_GRAPH_ID = "android-support-nav:fragment:graphId"
        private const val KEY_START_DESTINATION_ARGS =
            "android-support-nav:fragment:startDestinationArgs"

        @JvmStatic
        fun createDynamicNavHostFragment(
            @NavigationRes graphResId: Int,
            startDestinationArgs: Bundle? = null
        ): BaseDynamicNavHostFragment {



            val bundle: Bundle = Bundle().apply {
                putInt(KEY_GRAPH_ID, graphResId)

                if (startDestinationArgs != null) {
                    putBundle(KEY_START_DESTINATION_ARGS, startDestinationArgs)
                }
            }

            return BaseDynamicNavHostFragment().apply {
                arguments = bundle
            }
        }
    }
}
