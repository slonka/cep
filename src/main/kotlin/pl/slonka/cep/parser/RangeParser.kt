package pl.slonka.cep.parser

import pl.slonka.cep.expression.Range

class RangeParser {
    companion object {
        fun parse(input: String): Range {
            val fromTo = input.split("-")
            if (fromTo.size != 2) {
                throw InvalidRangeExpression("Range expression can only have one '-' sign between two positive integers.")
            }

            val from = parseRangeItem(fromTo[0])
            val to = parseRangeItem(fromTo[1])

            if (from > to) {
                throw InvalidRangeExpression("Range expression have to be in increasing order, e.g. 1-5, 3-7, not 5-1, 7-3.")
            }

            return Range(from, to)
        }

        private fun parseRangeItem(rawItem: String): Int {
            val item: Int
            try {
                item = rawItem.toInt()

                if (item < 0 || item > 59) {
                    throw InvalidRangeExpression("From value has to be between 0 and 59")
                }
            } catch (e: NumberFormatException) {
                throw InvalidRangeExpression("From value has to be a positive integer")
            }

            return item
        }
    }
}

class InvalidRangeExpression(s: String) : IllegalArgumentException(s)
