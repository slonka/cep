package pl.slonka.cep.converter

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import pl.slonka.cep.parser.InvalidRangeExpression

internal class ExpressionToTablePrinterConverterTest {

    @Test
    fun testValid() {
        // given
        val expected = """
            minute        0 15 30 45
            hour          0
            day of month  1 15
            month         1 2 3 4 5 6 7 8 9 10 11 12
            day of week   1 2 3 4 5
            command       /usr/bin/find""".trimIndent()

        // when
        val expanded = ExpressionToTable.convert("*/15 0 1,15 * 1-5 /usr/bin/find")

        // then
        assertEquals(expected, expanded)
    }

    @Test
    fun testInvalid() {
        assertThrows(InvalidRangeExpression::class.java) {
            // reversed range
            ExpressionToTable.convert("*/15 0 1,15 * 5-1 /usr/bin/find")
        }
    }
}