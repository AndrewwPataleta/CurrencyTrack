package andrew.pataleta.data.mapper.currency

import andrew.pataleta.data.mapper.BaseListMapper
import andrew.pataleta.data.mapper.BaseMapToListMapper
import andrew.pataleta.data.mapper.BaseMapper
import andrew.pataleta.data.model.local.CurrencyEntity
import andrew.pataleta.data.model.local.SymbolEntity
import andrew.pataleta.data.model.remote.CurrencyDTO
import andrew.pataleta.data.model.remote.ResponseRates

class CurrencyResponseToListEntityMapper: BaseMapToListMapper<ResponseRates, CurrencyEntity> {

    override fun map(input: ResponseRates): List<CurrencyEntity> {
        val entities = mutableListOf<CurrencyEntity>()
        input.rates.map { dto->
            entities.add(CurrencyEntity(name = dto.key, value = dto.value, parent = input.base, timestamp = input.timestamp))
        }
        return entities
    }

}