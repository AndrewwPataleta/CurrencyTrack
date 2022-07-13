package andrew.pataleta.features.currency.di

import andrew.pataleta.core.di.CoreModuleDependencies
import andrew.pataleta.features.currency.CurrencyFragment
import androidx.fragment.app.Fragment
import dagger.BindsInstance
import dagger.Component


@Component(dependencies = [CoreModuleDependencies::class], modules = [CurrencyModule::class])
interface CurrencyComponent {

    fun inject(loginFragment: CurrencyFragment)

    @Component.Factory
    interface Factory{
        fun create(
            dependenyModule: CoreModuleDependencies,
            @BindsInstance fragment: Fragment
        ): CurrencyComponent
    }
}