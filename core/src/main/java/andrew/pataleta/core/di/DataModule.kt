package andrew.pataleta.core.di

import andrew.pataleta.data.di.DatabaseModule
import andrew.pataleta.data.di.NetworkModule
import andrew.pataleta.data.mapper.currency.CurrencyResponseToListEntityMapper
import andrew.pataleta.data.mapper.currency.SymbolMapDTOtoListEntityMapper

import andrew.pataleta.data.repository.CurrencyRepository
import andrew.pataleta.data.repository.impl.CurrencyRepositoryImpl
import andrew.pataleta.data.source.CurrencyLocalDataSource
import andrew.pataleta.data.source.CurrencyRemoteDataSource
import andrew.pataleta.data.source.impl.CurrencyLocalDataSourceImpl
import andrew.pataleta.data.source.impl.CurrencyRemoteDataSourceImpl
import andrew.pataleta.domain.mapper.CurrencyEntityToItemListMapper
import andrew.pataleta.domain.mapper.SymbolEntityToItemListMapper
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module(includes = [NetworkModule::class, DatabaseModule::class, DataProviderModule::class])
interface DataModule  {

    @Singleton
    @Binds
    fun bindCurrencyLocalDataSource(remoteDataSource: CurrencyRemoteDataSourceImpl):
            CurrencyRemoteDataSource

    @Singleton
    @Binds
    fun bindCurrencyRemoteDataSource(localDataSource: CurrencyLocalDataSourceImpl):
            CurrencyLocalDataSource

    @Binds
    fun bindCurrencyRepository(repository: CurrencyRepositoryImpl):
            CurrencyRepository


}

@Module
@InstallIn(SingletonComponent::class)
object DataProviderModule {
    @Provides
    fun provideCurrencyResponseToListEntityMapper() = CurrencyResponseToListEntityMapper()

    @Provides
    fun provideSymbolMapDTOtoListEntityMapper() = SymbolMapDTOtoListEntityMapper()

    @Provides
    fun provideSymbolEntityToItemListMapper() = SymbolEntityToItemListMapper()

    @Provides
    fun provideCurrencyEntityToItemListMapper() = CurrencyEntityToItemListMapper()
}
