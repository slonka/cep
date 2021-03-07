package pl.slonka.cep.parser

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import pl.slonka.cep.expression.MinMax

internal class StepParserTest {

    @Test
    fun testValidStepValue() {
        // given
        val input = "1/4"

        // when
        val parsed = StepParser.parse(input, MinMax(0, 10))

        assertEquals(parsed.step, 4)
    }

    @Test
    fun testMultipleSlashes() {
        // given
        val input = "1/1/1"

        // when
        assertThrows(InvalidStepExpression::class.java) { StepParser.parse(input, MinMax(0, 10)) }
    }

    @Test
    fun testNonNumber() {
        // given
        val input = "1/a"

        // when
        assertThrows(InvalidStepExpression::class.java) { StepParser.parse(input, MinMax(0, 10)) }
    }

    @Test
    fun testNegative() {
        // given
        val input = "1/-4"

        // when
        assertThrows(InvalidStepExpression::class.java) { StepParser.parse(input, MinMax(0, 10)) }
    }

    @Test
    fun testInvalidStepValue() {
        // given
        val input = "1/0"

        // when
        assertThrows(InvalidStepExpression::class.java) { StepParser.parse(input, MinMax(0, 10)) }
    }
}