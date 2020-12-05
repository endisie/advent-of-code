class Day1Calculator : AdventCalculator {

    override fun calculatePart1(): Int {
        val text = this::class.java.getResourceAsStream("day1.txt").bufferedReader().readLines()

        val numbers = text.map { it.toInt() }.toSet()
        return numbers.mapNotNull {
            if (numbers.contains(2020 - it)) {
                it * (2020 - it)
            } else {
                null
            }
        }.first()
    }

    override fun calculatePart2(): Int {
        val text = this::class.java.getResourceAsStream("day1.txt").bufferedReader().readLines()

        val numbers = text.map { it.toInt() }
        for (i in (0..numbers.size - 2)) {
            for (j in (i + 1 until numbers.size)) {
                if (numbers.contains(2020 - numbers[i] - numbers[j]))
                    return numbers[i] * numbers[j] * (2020 - numbers[i] - numbers[j])
            }
        }
        return -1
    }

}