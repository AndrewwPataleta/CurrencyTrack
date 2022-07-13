package andrew.pataleta.data.mapper

interface BaseMapper<I,O> {
    fun map(input: I) : O
}

interface BaseListMapper<I, O>: BaseMapper<List<I>, List<O>>

interface BaseMapToListMapper<I, O>: BaseMapper<I, List<O>>