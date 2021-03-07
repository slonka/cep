package pl.slonka.cep.parser

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class Range(val from: Int, val to: Int): Expression {
    override fun values(min: Int, max: Int): List<Int> {
        return IntRange(Math.max(min, from), Math.min(max, to)).toList()
    }
}

class RangeParser {
    companion object {
        fun parse(input: String): Range {
            val fromTo = input.split("-")
            if (fromTo.size != 2) {
                throw InvalidCronRangeExpression("Range expression can only have one '-' sign between two positive integers.")
            }

            val from = parseRangeItem(fromTo[0])
            val to = parseRangeItem(fromTo[1])

            if (from > to) {
                throw InvalidCronRangeExpression("Range expression have to be in increasing order, e.g. 1-5, 3-7, not 5-1, 7-3.")
            }

            return Range(from, to)
        }

        private fun parseRangeItem(rawItem: String): Int {
            val item: Int
            try {
                item = rawItem.toInt()

                if (item < 0 || item > 59) {
                    throw InvalidCronRangeExpression("From value has to be between 0 and 59")
                }
            } catch (e: NumberFormatException) {
                throw InvalidCronRangeExpression("From value has to be a positive integer")
            }

            return item
        }
    }
}

class InvalidCronRangeExpression(s: String) : IllegalArgumentException(s)
