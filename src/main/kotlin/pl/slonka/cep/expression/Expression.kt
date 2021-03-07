package pl.slonka.cep.expression

interface Expression {
    fun values(min: Int, max: Int): List<Int>

}