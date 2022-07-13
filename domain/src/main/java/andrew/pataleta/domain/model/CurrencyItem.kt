package andrew.pataleta.domain.model

data class CurrencyItem(
    val key: String,
    val value: Double,
    val parent: String,
    val isFavorite: Boolean = false)
