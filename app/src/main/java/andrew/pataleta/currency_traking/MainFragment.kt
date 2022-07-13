package andrew.pataleta.currency_traking

import andrew.pataleta.core.ui.fragment.DynamicNavigationFragment
import andrew.pataleta.currency_traking.databinding.FragmentMainBinding
import andrew.pataleta.currency_traking.ui.BottomNavigationFragmentStateAdapter
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2

import timber.log.Timber

class MainFragment: DynamicNavigationFragment<FragmentMainBinding>() {

    override fun getLayoutRes(): Int = R.layout.fragment_main

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = dataBinding
        val viewPager2 = binding.viewPager
        val bottomNavigationView = binding.bottomNav

        viewPager2.apply {
            isUserInputEnabled = false
            offscreenPageLimit = 3
        }

        viewPager2.adapter = BottomNavigationFragmentStateAdapter(childFragmentManager, viewLifecycleOwner.lifecycle)


        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.list -> {
                    viewPager2.setCurrentItem(0, false)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.favorite -> {
                    viewPager2.setCurrentItem(1, false)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    viewPager2.setCurrentItem(0, false)
                    return@setOnNavigationItemSelectedListener true
                }
            }
        }

        viewPager2.setCurrentItem(
            0,
            false
        )
    }


    override fun onDestroyView() {
        super.onDestroyView()
    }

}