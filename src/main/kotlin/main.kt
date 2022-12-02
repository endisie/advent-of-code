import aoc2022.Day1Calculator
import aoc2022.Day2Calculator

fun main() {
    val day1 = Day1Calculator()
    val day2 = Day2Calculator()
    val advent = listOf(day1, day2)

    advent.forEach { it.printResults() }
}
