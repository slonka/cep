package pl.slonka.cep.parser

class Parser {
    fun parse(input: String): CronExpression {
        val parts = input.split(" ", limit = 6)

        val cronExpression = CronExpression(
            Expression.parseComplex(parts[0]),
            Expression.parseComplex(parts[1]),
            Expression.parseComplex(parts[2]),
            Expression.parseComplex(parts[3]),
            Expression.parseComplex(parts[4]),
            parts[5],
        )

        return cronExpression
    }
}

class CronExpression(
    val minute: List<Expression>,
    val hour: List<Expression>,
    val dayOfMonth: List<Expression>,
    val month: List<Expression>,
    val dayOfWeek: List<Expression>,
    val command: String,
)

interface Expression {
    fun values(min: Int, max: Int): List<Int>

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
