abstract class AbstractDayCalculator(private val day: Number) {

    abstract fun calculatePart1(): Any

    abstract fun calculatePart2(): Any

    fun getInputAsList(): List<String> {
        return this::class.java.getResourceAsStream("day$day.txt").bufferedReader().readLines()
    }

    fun getInputAsText(): String {
        return this::class.java.getResourceAsStream("day$day.txt").readBytes().toString(Charsets.UTF_8)
    }

}