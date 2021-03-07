package pl.slonka.cep.parser

import pl.slonka.cep.expression.CronExpression

class CronExpressionParser {
    fun parse(input: String): CronExpression {
        val parts = input.split(" ", limit = 6)

        val cronExpression = CronExpression(
            ExpressionParser.parseComplex(parts[0]),
            ExpressionParser.parseComplex(parts[1]),
            ExpressionParser.parseComplex(parts[2]),
            ExpressionParser.parseComplex(parts[3]),
            ExpressionParser.parseComplex(parts[4]),
            parts[5],
        )

        return cronExpression
    }
}

