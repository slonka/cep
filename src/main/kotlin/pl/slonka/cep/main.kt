package pl.slonka.cep

import pl.slonka.cep.converter.ExpressionToTable
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.size != 1) {
        help()
        exitProcess(1)
    }

    val input = args[0].removeSurrounding("\"")
    try {
        println(ExpressionToTable.convert(input))
    } catch (e: Exception) {
        println("Could not parse $input. Reason: $e")
        exitProcess(2)
    }
}

fun help() {
    println("Please provide CRON expression as a command-line argument")
}
