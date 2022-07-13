package andrew.pataleta.core.ui.fragment

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.dynamicfeatures.DynamicExtras
import androidx.navigation.dynamicfeatures.DynamicInstallMonitor
import com.google.android.play.core.splitinstall.SplitInstallSessionState
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus

abstract class DynamicNavigationFragment<ViewBinding: ViewDataBinding>: BaseDataBindingFragment<ViewBinding>() {

    fun navigateWithInstallMonitor(
        navController: NavController,
        @IdRes resId: Int,
        args: Bundle? = null,
        navOptions: NavOptions? = null,
    ) {

        val installMonitor = DynamicInstallMonitor()

        navController.navigate(
            resId,
            args,
            navOptions,
            DynamicExtras(installMonitor)
        )

        if (installMonitor.isInstallRequired) {

            installMonitor.status.observe(
                viewLifecycleOwner,
                object : Observer<SplitInstallSessionState> {

                    override fun onChanged(sessionState: SplitInstallSessionState) {

                        when (sessionState.status()) {

                            SplitInstallSessionStatus.INSTALLED -> {

                                navController.navigate(
                                    resId,
                                    args,
                                    navOptions,
                                    DynamicExtras(installMonitor)
                                )
                            }
                            SplitInstallSessionStatus.REQUIRES_USER_CONFIRMATION -> {
                            }

                            SplitInstallSessionStatus.FAILED -> {
                            }
                            SplitInstallSessionStatus.CANCELED -> {
                            }
                        }

                        if (sessionState.hasTerminalStatus()) {
                            installMonitor.status.removeObserver(this)
                        }
                    }
                }
            )
        }
    }

}