package pl.slonka.cep.parser

import pl.slonka.cep.expression.Value

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
