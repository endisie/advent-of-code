package aoc2022

import AbstractDayCalculator

class Day6Calculator : AbstractDayCalculator(2022, 6, "Tuning Trouble") {

    override fun calculatePart1(): Any {
        val input = getInputAsText()

        return findDistinctCharactersIndex(input)
    }

    override fun calculatePart2(): Any {
        val input = getInputAsText()

        val window = 14
        return input.withIndex()
            .windowed(window)
            .first { charList -> charList.map { it.value }.toSet().size == window }
            .last().index + 1

    }

    private fun findDistinctCharactersIndex(input: String): Int {
        for (i in 0..input.length - 4) {
            val marker = input.substring(i, i + 4).toSet()
            if (marker.size == 4) {
                return i + 4
            }
        }
        return 0
    }

}