package pl.slonka.cep.parser

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import pl.slonka.cep.expression.MinMax
import pl.slonka.cep.expression.Range

internal class RangeParserTest {

    @Test
    fun testValueInsideRange() {
        // given
        val input = "1-3"

        // when
        val parsed = RangeParser.parse(input, MinMax(0, 10))

        // then
        assertEquals(Range(1, 3), parsed)
    }

    @Test
    fun testInvalidRangeValue() {
        // given
        val input = "1-b"

        // when
        assertThrows(InvalidRangeExpression::class.java) {
            RangeParser.parse(input, MinMax(2, 10))
        }
    }

    @Test
    fun testInvertedRange() {
        // given
        val input = "5-1"

        // when
        assertThrows(InvalidRangeExpression::class.java) {
            RangeParser.parse(input, MinMax(0, 10))
        }
    }

    @Test
    fun testMissingRange() {
        // given
        val input = "1-"

        // when
        assertThrows(InvalidRangeExpression::class.java) {
            RangeParser.parse(input, MinMax(0, 10))
        }
    }

    @Test
    fun testMultipleDashes() {
        // given
        val input = "1-4-"

        // when
        assertThrows(InvalidRangeExpression::class.java) {
            RangeParser.parse(input, MinMax(0, 10))
        }
    }

    @Test
    fun testFromOutsideRange() {
        // given
        val input = "1-4"

        // when
        assertThrows(InvalidRangeExpression::class.java) {
            RangeParser.parse(input, MinMax(2, 10))
        }
    }

    @Test
    fun testToOutsideRange() {
        // given
        val input = "1-40"

        // when
        assertThrows(InvalidRangeExpression::class.java) {
            RangeParser.parse(input, MinMax(0, 10))
        }
    }
}