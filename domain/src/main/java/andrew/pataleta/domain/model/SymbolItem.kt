package andrew.pataleta.domain.model

data class SymbolItem(
    val key: String,
    val value: String,
    val isFavorite: Boolean = false)
