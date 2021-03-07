package pl.slonka.cep.parser

import pl.slonka.cep.expression.CronExpression
import pl.slonka.cep.expression.Limits

class CronExpressionParser {
    fun parse(input: String): CronExpression {
        val parts = input.split(" ", limit = 6)

        val cronExpression = CronExpression(
            ExpressionParser.parseComplex(parts[0], Limits.minutes),
            ExpressionParser.parseComplex(parts[1], Limits.hours),
            ExpressionParser.parseComplex(parts[2], Limits.dayOfMonth),
            ExpressionParser.parseComplex(parts[3], Limits.month),
            ExpressionParser.parseComplex(parts[4], Limits.dayOfWeek),
            parts[5],
        )

        return cronExpression
    }
}

