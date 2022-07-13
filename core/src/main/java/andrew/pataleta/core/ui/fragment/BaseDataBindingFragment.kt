package andrew.pataleta.core.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment


abstract class BaseDataBindingFragment<ViewBinding: ViewDataBinding>: Fragment() {

   private var _dataBinding: ViewBinding? = null

    open val dataBinding: ViewBinding get() = _dataBinding!!

    @LayoutRes
    abstract fun getLayoutRes(): Int

    override fun onCreateView(inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstance: Bundle?) : View? {

        setHasOptionsMenu(true)
        _dataBinding = DataBindingUtil.inflate(inflater, getLayoutRes(), container, false)

        dataBinding.lifecycleOwner = viewLifecycleOwner
        return  dataBinding.root
    }


    open fun bindViews(view: View, savedInstanceState: Bundle?) = Unit

    override fun onDestroyView() {
        super.onDestroyView()
        _dataBinding = null
    }

}