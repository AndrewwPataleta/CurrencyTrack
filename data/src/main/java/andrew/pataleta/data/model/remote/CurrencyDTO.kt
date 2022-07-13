package andrew.pataleta.data.model.remote

import andrew.pataleta.data.mapper.DataTransferObject

data class CurrencyDTO(val name: String, val value: Long) : DataTransferObject