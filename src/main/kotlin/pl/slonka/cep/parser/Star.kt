package pl.slonka.cep.parser

import java.lang.IllegalArgumentException

class Star: Expression {
    override fun values(min: Int, max: Int): List<Int> {
        return IntRange(min, max).toList()
    }
}

class StarParser {
    companion object {
        fun parse(input: String): Star {
            if (input != "*") {
                throw InvalidStarExpression("Star expression can only have one '*'.")
            }
            return Star()
        }
    }
}

class InvalidStarExpression(s: String) : IllegalArgumentException(s)
