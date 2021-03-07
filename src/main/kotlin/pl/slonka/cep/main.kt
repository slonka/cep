package pl.slonka.cep

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        help()
        exitProcess(1)
    }

    exitProcess(0)
}

fun help() {
    println("Please provide a name as a command-line argument")
}
