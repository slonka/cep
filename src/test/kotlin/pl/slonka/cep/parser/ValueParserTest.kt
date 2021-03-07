package pl.slonka.cep.parser

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import pl.slonka.cep.expression.MinMax
import pl.slonka.cep.expression.Value

internal class ValueParserTest {

    @Test
    fun testValueInsideRange() {
        // given
        val input = "1"

        // when
        val parsed = ValueParser.parse(input, MinMax(0, 10))

        assertEquals(Value(1), parsed)
    }

    @Test
    fun testValueOutsideRange() {
        // given
        val input = "11"

        // when
        assertThrows(InvalidValueExpression::class.java) { ValueParser.parse(input, MinMax(0, 10)) }
    }

    @Test
    fun testNonIntegerValue() {
        // given
        val input = "asdf"

        // when
        assertThrows(InvalidValueExpression::class.java) { ValueParser.parse(input, MinMax(0, 10)) }
    }
}