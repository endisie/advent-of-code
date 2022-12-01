package aoc2020

import AbstractDayCalculator

class Day3Calculator : AbstractDayCalculator(2022, 3, "Toboggan Trajectory") {

    override fun calculatePart1(): Int {
        return calculateSlope(3, 1)
    }

    override fun calculatePart2(): Int {
        val slopes = listOf(Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2))
        var result = 1
        for (slope in slopes) {
            result *= calculateSlope(slope.first, slope.second)
        }

        return result
    }

    private fun calculateSlope(slopeX: Int, slopeY: Int): Int {
        val lines = getInputAsList()

        var x = 0
        var y = 0
        var trees = 0
        while (y < lines.size) {
            if (lines[y][x] == '#') {
                trees++
            }
            x = (x + slopeX) % lines[y].length
            y += slopeY
        }
        return trees
    }

}