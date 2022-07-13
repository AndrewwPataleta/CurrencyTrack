package andrew.pataleta.data.di

import andrew.pataleta.data.db.CurrencyDao
import andrew.pataleta.data.db.CurrencyDatabase
import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application): CurrencyDatabase {
        return Room.databaseBuilder(
            application,
            CurrencyDatabase::class.java,
            "CurrencyDatabase"
        ).build()
    }

    @Provides
    fun provideCurrencyDao(appDatabase: CurrencyDatabase): CurrencyDao =
        appDatabase.currencyDao()
}