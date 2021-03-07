package pl.slonka.cep.expression

data class Range(val from: Int, val to: Int): Expression {
    override fun values(min: Int, max: Int): List<Int> {
        return IntRange(Math.max(min, from), Math.min(max, to)).toList()
    }
}