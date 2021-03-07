package pl.slonka.cep.converter

import pl.slonka.cep.parser.CronExpressionParser
import pl.slonka.cep.printer.TablePrinter

class ExpressionToTable {
    companion object {
        private val printer = TablePrinter()
        private val parser = CronExpressionParser()

        fun convert(input: String): String {
            val cronExpression = parser.parse(input)
            return printer.format(cronExpression)
        }
    }
}