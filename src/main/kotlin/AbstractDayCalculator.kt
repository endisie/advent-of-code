abstract class AbstractDayCalculator(private val year: Number, private val day: Number, private val title: String) {

    abstract fun calculatePart1(): Any

    abstract fun calculatePart2(): Any

    fun getInputAsList(): List<String> {
        return this::class.java.getResourceAsStream("/aoc$year/day$day.txt").bufferedReader().readLines()
    }

    fun getInputAsText(): String {
        print(year)
        return this::class.java.getResourceAsStream("/aoc$year/day$day.txt").readBytes().toString(Charsets.UTF_8)
    }

    fun printResults() {
        println("--- Day $day: $title ---")
        println("Part 1: ${calculatePart1()}")
        println("Part 2: ${calculatePart2()}")
        println()
    }

}