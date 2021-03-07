package pl.slonka.cep.parser

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

internal class StarParserTest {

    @Test
    fun testValidStarValue() {
        // given
        val input = "*"

        // when
        assertDoesNotThrow {
            StarParser.parse(input)
        }
    }

    @Test
    fun testDoubleStars() {
        // given
        val input = "**"

        // when
        assertThrows(InvalidStarExpression::class.java) { StarParser.parse(input) }
    }

    @Test
    fun testNoStars() {
        // given
        val input = "a"

        // when
        assertThrows(InvalidStarExpression::class.java) { StarParser.parse(input) }
    }
}