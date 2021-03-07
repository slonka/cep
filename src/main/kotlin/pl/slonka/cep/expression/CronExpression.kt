package pl.slonka.cep.expression

class CronExpression(
    val minute: List<Expression>,
    val hour: List<Expression>,
    val dayOfMonth: List<Expression>,
    val month: List<Expression>,
    val dayOfWeek: List<Expression>,
    val command: String,
)