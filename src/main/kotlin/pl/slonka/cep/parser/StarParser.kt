package pl.slonka.cep.parser

import pl.slonka.cep.expression.Star

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
