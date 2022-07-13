package andrew.pataleta.data.mapper.currency

import andrew.pataleta.data.mapper.BaseListMapper
import andrew.pataleta.data.mapper.BaseMapToListMapper
import andrew.pataleta.data.mapper.BaseMapper
import andrew.pataleta.data.model.local.CurrencyEntity
import andrew.pataleta.data.model.local.SymbolEntity
import andrew.pataleta.data.model.remote.CurrencyDTO

class SymbolMapDTOtoListEntityMapper: BaseMapToListMapper<Map<String, String>, SymbolEntity> {

    override fun map(input: Map<String, String>): List<SymbolEntity> {
        val entities = mutableListOf<SymbolEntity>()
        input.map { dto->
            entities.add(SymbolEntity(dto.key, dto.value, false))
        }
        return entities
    }

}