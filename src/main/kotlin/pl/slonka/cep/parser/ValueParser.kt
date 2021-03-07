package pl.slonka.cep.parser

import pl.slonka.cep.expression.MinMax
import pl.slonka.cep.expression.Value

class ValueParser {
    companion object {
        fun parse(input: String, limit: MinMax): Value {
            val value: Int
            try {
                value = input.toInt()
                if (value < limit.min || value > limit.max) {
                    throw InvalidValueExpression("Value has to be between ${limit.min} and ${limit.max}")
                }
            } catch (e: NumberFormatException) {
                throw InvalidValueExpression("Value has to be a positive integer between ${limit.min} and ${limit.max}")
            }

            return Value(value)
        }
    }
}

class InvalidValueExpression(s: String) : IllegalArgumentException(s)
