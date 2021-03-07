package pl.slonka.cep.parser

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class Value(val value: Int): Expression {
    override fun values(min: Int, max: Int): List<Int> {
        if (value < min || value > max) {
            throw InvalidValueExpression("Value $value outside of min/max range ($min, $max)")
        }

        return listOf(value)
    }
}

class ValueParser {
    companion object {
        fun parse(input: String): Value {
            val value: Int
            try {
                value = input.toInt()
            } catch (e: NumberFormatException) {
                throw InvalidValueExpression("Value has to be a positive integer")
            }

            return Value(value)
        }
    }
}

class InvalidValueExpression(s: String) : IllegalArgumentException(s)
