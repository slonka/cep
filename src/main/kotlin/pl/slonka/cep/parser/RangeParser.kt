package pl.slonka.cep.parser

import pl.slonka.cep.expression.MinMax
import pl.slonka.cep.expression.Range

class RangeParser {
    companion object {
        fun parse(input: String, limit: MinMax): Range {
            val fromTo = input.split("-")
            if (fromTo.size != 2) {
                throw InvalidRangeExpression("Range expression can only have one '-' sign between two positive integers.")
            }

            val from = parseRangeItem(fromTo[0], limit)
            val to = parseRangeItem(fromTo[1], limit)

            if (from > to) {
                throw InvalidRangeExpression("Range expression have to be in increasing order, e.g. 1-5, 3-7, not 5-1, 7-3.")
            }

            return Range(from, to)
        }

        private fun parseRangeItem(rawItem: String, limit: MinMax): Int {
            val item: Int
            try {
                item = rawItem.toInt()

                if (item < limit.min || item > limit.max) {
                    throw InvalidRangeExpression("From value has to be between ${limit.min} and ${limit.max}")
                }
            } catch (e: NumberFormatException) {
                throw InvalidRangeExpression("From value has to be a positive integer between ${limit.min} and ${limit.max}")
            }

            return item
        }
    }
}

class InvalidRangeExpression(s: String) : IllegalArgumentException(s)
