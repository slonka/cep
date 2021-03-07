package pl.slonka.cep.sys

import pl.slonka.cep.parser.Parser
import pl.slonka.cep.printer.Table

class Runner {
    companion object {
        private val printer = Table()
        private val parser = Parser()

        fun run(input: String) {
            val cronExpression = parser.parse(input)
            val formatted = printer.format(cronExpression)
            println(formatted)
        }
    }
}

fun main() {
    Runner.run("*/15 0 1,15 * 1-5 /usr/bin/find")
}