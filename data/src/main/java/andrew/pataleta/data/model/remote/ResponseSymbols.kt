package andrew.pataleta.data.model.remote

import andrew.pataleta.data.mapper.DataTransferObject

data class ResponseSymbols (
     val symbols: Map<String, String>,
     val success: Boolean,
    ) : DataTransferObject