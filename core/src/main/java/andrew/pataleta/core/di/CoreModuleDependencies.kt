package andrew.pataleta.core.di


import andrew.pataleta.domain.usecase.currency.GetCurrencyUseCase
import andrew.pataleta.domain.usecase.symbol.GetSymbolsUseCase
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface CoreModuleDependencies {

    fun getSymbolsUseCase(): GetSymbolsUseCase

    fun getCurrencyUseCase(): GetCurrencyUseCase

}
