package pl.slonka.cep.expression

class Star: Expression {
    override fun values(min: Int, max: Int): List<Int> {
        return IntRange(min, max).toList()
    }
}