package andrew.pataleta.data.model.remote

import andrew.pataleta.data.mapper.DataTransferObject

data class ResponseRates (
     val base: String,
     val date: String,
     val rates: Map<String, Double>,
     val success: Boolean,
     val timestamp: Long
     ) : DataTransferObject