package aoc2022

import AbstractDayCalculator

class Day2Calculator : AbstractDayCalculator(2022, 2, "Rock Paper Scissors") {

    private val lose = 0
    private val draw = 3
    private val win = 6

    private val rock = 1
    private val paper = 2
    private val scissors = 3

    override fun calculatePart1(): Any {
        val rounds = mapOf(
            "A X" to draw + rock,
            "A Y" to win + paper,
            "A Z" to lose + scissors,
            "B X" to lose + rock,
            "B Y" to draw + paper,
            "B Z" to win + scissors,
            "C X" to win + rock,
            "C Y" to lose + paper,
            "C Z" to draw + scissors,
        )
        val input = getInputAsList()
        return input.sumOf { rounds[it] ?: 0 }
    }

    override fun calculatePart2(): Any {
        val rounds = mapOf(
            "A X" to lose + scissors,
            "A Y" to draw + rock,
            "A Z" to win + paper,
            "B X" to lose + rock,
            "B Y" to draw + paper,
            "B Z" to win + scissors,
            "C X" to lose + paper,
            "C Y" to draw + scissors,
            "C Z" to win + rock,
        )

        val input = getInputAsList()
        return input.sumOf { rounds[it] ?: 0 }
    }

}