package aoc2020

import AbstractDayCalculator

class Day6Calculator : AbstractDayCalculator(6, "Custom Customs") {

    override fun calculatePart1(): Int {
        val groups = getInputAsText().split("\r\n\r\n")
        var answers = 0
        for (group in groups) {
            answers += group.replace(Regex("\\s"), "").toSet().size
        }
        return answers
    }

    override fun calculatePart2(): Int {
        val groups = getInputAsText().split("\r\n\r\n")
        var answers = 0
        for (group in groups) {
            val answersPerPerson = group.split("\n")
            var uniqueChars = answersPerPerson[0].toSet()
            for (char in answersPerPerson) {
                uniqueChars = uniqueChars.intersect(char.toSet())
            }
            answers += uniqueChars.size
        }
        return answers
    }

}