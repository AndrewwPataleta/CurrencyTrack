package andrew.pataleta.data.api

import andrew.pataleta.data.model.remote.ResponseRates
import andrew.pataleta.data.model.remote.ResponseSymbols
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyService {

    @GET("symbols")
    suspend fun getSymbols(): ResponseSymbols


    @GET("latest")
    suspend fun getCurrency(@Query("base") base: String): ResponseRates

}