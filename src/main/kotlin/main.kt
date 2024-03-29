import aoc2022.Day1Calculator
import aoc2022.Day2Calculator
import aoc2022.Day3Calculator
import aoc2022.Day4Calculator
import aoc2022.Day6Calculator

fun main() {
    val day1 = Day1Calculator()
    val day2 = Day2Calculator()
    val day3 = Day3Calculator()
    val day4 = Day4Calculator()
    val day6 = Day6Calculator()
    val advent = listOf(day1, day2, day3, day4, day6)

    advent.forEach { it.printResults() }
}
