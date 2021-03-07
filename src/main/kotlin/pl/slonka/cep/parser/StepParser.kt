package pl.slonka.cep.parser

import pl.slonka.cep.expression.MinMax
import pl.slonka.cep.expression.Step

class StepParser {
    companion object {
        fun parse(input: String, limit: MinMax): Step {
            val expressionAndStep = input.split("/")

            if (expressionAndStep.size != 2) {
                throw InvalidStepExpression("Step value can contain only one '/'." +
                        "It is defined in the following format: 'expression'/'positive integer'.")
            }

            val expression = ExpressionParser.parseSimple(expressionAndStep[0], limit)
            val step: Int

            try {
                step = expressionAndStep[1].toInt()
            } catch (e: NumberFormatException) {
                throw InvalidStepExpression("Step value has to be a positive integer")
            }

            if (step <= 0) {
                throw InvalidStepExpression("Step value has to be higher than 0")
            }

            return Step(expression, step)
        }
    }
}

class InvalidStepExpression(s: String) : IllegalArgumentException(s)
