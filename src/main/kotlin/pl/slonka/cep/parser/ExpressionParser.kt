package pl.slonka.cep.parser

import pl.slonka.cep.expression.Expression
import pl.slonka.cep.expression.MinMax

class ExpressionParser {
    companion object {
        fun parseComplex(input: String, limit: MinMax): List<Expression> {
            val parts = input.split(",")

            return parts.map { part -> parseSimple(part, limit) }
        }

        fun parseSimple(input: String, limit: MinMax): Expression {
            return when {
                input.contains("/") -> {
                    StepParser.parse(input, limit)
                }
                input.contains("-") -> {
                    RangeParser.parse(input, limit)
                }
                input.contains("*") -> {
                    StarParser.parse(input)
                }
                else -> {
                    ValueParser.parse(input, limit)
                }
            }
        }
    }
}