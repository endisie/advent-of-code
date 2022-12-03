package aoc2022

import AbstractDayCalculator

class Day3Calculator : AbstractDayCalculator(2022, 3, "Rucksack Reorganization") {

    private val priorityScore = "-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    override fun calculatePart1(): Any {
        val input = getInputAsList()
        val priorities = mutableListOf<Int>()
        for (rucksack in input) {
            val comp1 = rucksack.substring(0, rucksack.length / 2).toSet()
            val comp2 = rucksack.substring(rucksack.length / 2).toSet()
            val commonItems = comp1.intersect(comp2)
            val priorityTotal = commonItems.sumOf { priorityScore.indexOf(it) }
            priorities.add(priorityTotal)
        }

        return priorities.sum()
    }

    override fun calculatePart2(): Any {
        val input = getInputAsList()
        val priorities = mutableListOf<Int>()
        var i = 0
        while (i < input.size - 2) {
            val rucksack1 = input[i].toSet()
            val rucksack2 = input[i + 1].toSet()
            val rucksack3 = input[i + 2].toSet()
            val commonItems = rucksack1.intersect(rucksack2).intersect(rucksack3)
            val priorityTotal = commonItems.sumOf { priorityScore.indexOf(it) }
            priorities.add(priorityTotal)
            i += 3
        }

        return priorities.sum()
    }

}