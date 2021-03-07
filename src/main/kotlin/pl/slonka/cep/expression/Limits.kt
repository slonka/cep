package pl.slonka.cep.expression

class Limits {
    companion object {
        val minutes = MinMax(0, 59)
        val hours = MinMax(0, 23)
        val dayOfMonth = MinMax(1, 31)
        val month = MinMax(1, 12)
        val dayOfWeek = MinMax(0, 7)
    }
}

data class MinMax(val min: Int, val max: Int)