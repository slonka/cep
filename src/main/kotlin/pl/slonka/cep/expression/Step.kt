package pl.slonka.cep.expression

class Step (val expression: Expression, val step: Int): Expression {
    override fun values(min: Int, max: Int): List<Int> {
        return expression.values(min, max).filterIndexed { index, _ ->
            index.rem(step) == 0
        }
    }
}