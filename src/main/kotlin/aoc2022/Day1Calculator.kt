package aoc2022

import AbstractDayCalculator

class Day1Calculator : AbstractDayCalculator(2022, 1, "Calorie Counting") {

    override fun calculatePart1(): Any {
        val inputList = getInputAsList()

        var max = 0
        var count = 0
        for (calorie in inputList) {
            if ("" == calorie) {
                count = 0
            } else {
                count += calorie.toInt()
                if (count > max) {
                    max = count
                }
            }
        }
        return max
    }

    override fun calculatePart2(): Any {
        val inputList = getInputAsList()
        var caloriesPerElf = 0
        val calorieTotals = mutableListOf<Int>()

        for (calorie in inputList) {
            if ("" == calorie) {
                calorieTotals.add(caloriesPerElf)
                caloriesPerElf = 0
            } else {
                caloriesPerElf += calorie.toInt()
            }
        }

        return calorieTotals
            .sortedByDescending { it }
            .slice(IntRange(0, 2))
            .sum()
    }

}