package pl.slonka.cep.printer

import pl.slonka.cep.expression.CronExpression
import pl.slonka.cep.expression.Expression
import pl.slonka.cep.expression.Limits

class TablePrinter {
    companion object {
        const val PADDING = 14
        const val SEPARATOR = " "
    }

    fun format(cronExpression: CronExpression): String {
        val minutes = formatMinutes(cronExpression.minute)
        val hours = formatHours(cronExpression.hour)
        val dayOfMonth = formatDayOfMonth(cronExpression.dayOfMonth)
        val month = formatMonth(cronExpression.month)
        val dayOfWeek = formatDayOfWeek(cronExpression.dayOfWeek)
        val command = formatCommand(cronExpression.command)

        return """
            $minutes
            $hours
            $dayOfMonth
            $month
            $dayOfWeek
            $command
        """.trimIndent()
    }

    private fun formatCommand(command: String): String {
        return "command".padEnd(PADDING) + command
    }

    private fun formatDayOfWeek(dayOfWeek: List<Expression>): String {
        val unique = uniqueExpressionValues(dayOfWeek, Limits.dayOfWeek.min, Limits.dayOfWeek.max)
        return "day of week".padEnd(PADDING) + unique.joinToString(SEPARATOR)
    }

    private fun formatMonth(month: List<Expression>): String {
        val unique = uniqueExpressionValues(month, Limits.month.min, Limits.month.max)
        return "month".padEnd(PADDING) + unique.joinToString(SEPARATOR)
    }

    private fun formatDayOfMonth(dayOfMonth: List<Expression>): String {
        val unique = uniqueExpressionValues(dayOfMonth, Limits.dayOfMonth.min, Limits.dayOfMonth.max)
        return "day of month".padEnd(PADDING) + unique.joinToString(SEPARATOR)
    }

    private fun formatHours(hour: List<Expression>): String {
        val unique = uniqueExpressionValues(hour, Limits.hours.min, Limits.hours.max)
        return "hour".padEnd(PADDING) + unique.joinToString(SEPARATOR)
    }

    private fun formatMinutes(minute: List<Expression>): String {
        val unique = uniqueExpressionValues(minute, Limits.minutes.min, Limits.minutes.max)
        return "minute".padEnd(PADDING) + unique.joinToString(SEPARATOR)
    }

    private fun uniqueExpressionValues(expressions: List<Expression>, min: Int, max: Int): Set<Int> {
        return expressions.flatMap { it.values(min, max) }.toSet()
    }
}