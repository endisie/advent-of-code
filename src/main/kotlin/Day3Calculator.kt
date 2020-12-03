class Day3Calculator : AdventCalculator {

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
        val text = this::class.java.getResourceAsStream("day3.txt").bufferedReader().readLines()

        var x = 0
        var y = 0
        var trees = 0
        while (y < text.size) {
            if (text[y][x] == '#') {
                trees++
            }
            x = (x + slopeX) % text[y].length
            y += slopeY
        }
        return trees
    }

}