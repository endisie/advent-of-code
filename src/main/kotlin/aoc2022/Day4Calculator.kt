package aoc2022

import AbstractDayCalculator

class Day4Calculator : AbstractDayCalculator(2022, 4, "Camp Cleanup") {

    override fun calculatePart1(): Any {
        val input = getInputAsList()
        var count = 0

        for (entry in input) {
            val assignments = entry.split(",")
            val assignment1 = assignments[0].split("-")
            val assignment2 = assignments[1].split("-")
            if (assignment1[0].toInt() <= assignment2[0].toInt() && assignment1[1].toInt() >= assignment2[1].toInt()) {
                count++
            } else if (assignment2[0].toInt() <= assignment1[0].toInt() && assignment2[1].toInt() >= assignment1[1].toInt()) {
                count++
            }
        }

        return count
    }

    override fun calculatePart2(): Any {
        val input = getInputAsList()

        return input.map { it.asRanges() }
            .count { it.first.intersect(it.second).isNotEmpty() }
    }

    private fun String.asRanges(): Pair<Set<Int>, Set<Int>> {
        return substringBefore(",").asIntRange().toSet() to substringAfter(",").asIntRange().toSet()
    }

    private fun String.asIntRange(): IntRange {
        return substringBefore("-").toInt()..substringAfter("-").toInt()
    }

}