package pl.slonka.cep.parser

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ParserTest {

    @Test
    fun testParse() {
        // given
        val parser = Parser()
        val expected = """
            minute        0 15 30 45
            hour          0
            day of month  1 15
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   1 2 3 4 5
            command       /usr/bin/find""".trimIndent()

        // when
        val expanded = parser.parse("*/15 0 1,15 * 1-5 /usr/bin/find")

        // then
        assertEquals(expected, expanded)
    }
}