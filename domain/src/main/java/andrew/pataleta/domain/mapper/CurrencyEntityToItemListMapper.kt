package andrew.pataleta.domain.mapper

import andrew.pataleta.data.model.local.CurrencyEntity
import andrew.pataleta.data.model.local.SymbolEntity
import andrew.pataleta.domain.model.CurrencyItem
import andrew.pataleta.domain.model.SymbolItem

class CurrencyEntityToItemListMapper:
    ListMapper<CurrencyEntity, CurrencyItem> {

    override fun map(input: List<CurrencyEntity>): List<CurrencyItem> {
        return input.map {
            CurrencyItem(it.name, it.value, it.parent)
        }
    }
}