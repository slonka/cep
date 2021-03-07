package pl.slonka.cep.expression

import pl.slonka.cep.parser.InvalidValueExpression

data class Value(val value: Int): Expression {
    override fun values(min: Int, max: Int): List<Int> {
        if (value < min || value > max) {
            throw InvalidValueExpression("Value $value outside of min/max range ($min, $max)")
        }

        return listOf(value)
    }
}