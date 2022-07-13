package andrew.pataleta.data.model.remote

import andrew.pataleta.data.mapper.DataTransferObject

data class SymbolDTO (
    val name: String,
    val value: Long,
    val rates: Map<String, Long>
    ) : DataTransferObject