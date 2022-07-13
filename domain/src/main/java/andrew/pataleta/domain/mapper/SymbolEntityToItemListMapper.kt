package andrew.pataleta.domain.mapper

import andrew.pataleta.data.model.local.SymbolEntity
import andrew.pataleta.domain.model.SymbolItem

class SymbolEntityToItemListMapper:
    ListMapper<SymbolEntity, SymbolItem> {

    override fun map(input: List<SymbolEntity>): List<SymbolItem> {

        return input.map {
            SymbolItem(it.key, it.value, it.isFavorite)
        }
    }
}