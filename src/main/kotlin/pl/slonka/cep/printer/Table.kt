package pl.slonka.cep.printer

import pl.slonka.cep.parser.CronExpression
import pl.slonka.cep.parser.Expression

class Table {
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
        val unique = uniqueExpressionValues(dayOfWeek, 0, 7)
        return "day of week".padEnd(PADDING) + unique.joinToString(SEPARATOR)
    }

    private fun formatMonth(month: List<Expression>): String {
        val unique = uniqueExpressionValues(month, 1, 12)
        return "month".padEnd(PADDING) + unique.joinToString(SEPARATOR)
    }

    private fun formatDayOfMonth(dayOfMonth: List<Expression>): String {
        val unique = uniqueExpressionValues(dayOfMonth, 1, 31)
        return "day of month".padEnd(PADDING) + unique.joinToString(SEPARATOR)
    }

    private fun formatHours(hour: List<Expression>): String {
        val unique = uniqueExpressionValues(hour, 0, 23)
        return "hour".padEnd(PADDING) + unique.joinToString(SEPARATOR)
    }

    private fun formatMinutes(minute: List<Expression>): String {
        val unique = uniqueExpressionValues(minute, 0, 59)
        return "minute".padEnd(PADDING) + unique.joinToString(SEPARATOR)
    }

    private fun uniqueExpressionValues(expressions: List<Expression>, min: Int, max: Int): Set<Int> {
        return expressions.flatMap { it.values(min, max) }.toSet()
    }
}