package pl.slonka.cep.parser

import pl.slonka.cep.expression.Expression

class ExpressionParser {
    companion object {
        fun parseComplex(input: String): List<Expression> {
            val parts = input.split(",")

            return parts.map { part -> parseSimple(part) }
        }

        fun parseSimple(input: String): Expression {
            return when {
                input.contains("/") -> {
                    StepParser.parse(input)
                }
                input.contains("-") -> {
                    RangeParser.parse(input)
                }
                input.contains("*") -> {
                    StarParser.parse(input)
                }
                else -> {
                    ValueParser.parse(input)
                }
            }
        }
    }
}