package andrew.pataleta.currency_traking.ui

import andrew.pataleta.core.ui.fragment.viewpager2.NavigableFragmentStateAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import andrew.pataleta.core.ui.fragment.navhost.NavHostContainerFragment
import andrew.pataleta.currency_traking.R


class BottomNavigationFragmentStateAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    NavigableFragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {

            0 -> NavHostContainerFragment.createNavHostContainerFragment(
                R.layout.fragment_navhost_currency,
                R.id.nested_nav_host_fragment_currency
            )
            1 -> NavHostContainerFragment.createNavHostContainerFragment(
                R.layout.fragment_navhost_currency_favorite,
                R.id.nested_nav_host_fragment_currency_favorite
            )
            else -> {
                return Fragment()
            }
        }
    }
}
