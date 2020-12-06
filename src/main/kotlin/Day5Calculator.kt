class Day5Calculator : AbstractDayCalculator(5, "Binary Boarding") {

    override fun calculatePart1(): Int {
        return getInputAsList()
            .map { calculateSeatId(it) }
            .maxOrNull() ?: -1
    }

    override fun calculatePart2(): Int {
        val seatIds = getInputAsList().map { calculateSeatId(it) }
        return seatIds
            .sorted()
            .zipWithNext()
            .first { it.first + 1 != it.second }
            .first + 1
    }

    private fun calculateSeatId(encodedId: String): Int {
        var rows = (0..127).toList()
        var cols = (0..7).toList()
        val encodedRow = encodedId.slice(0..6)
        val encodedCol = encodedId.slice(7..9)
        for (sorting in encodedRow) {
            rows = divideInput(rows, sorting)
        }
        for (sorting in encodedCol) {
            cols = divideInput(cols, sorting)
        }
        return rows[0] * 8 + cols[0]
    }

    private fun divideInput(places: List<Int>, sorting: Char): List<Int> {
        return if (sorting in "FL") {
            places.subList(0, places.size / 2)
        } else {
            places.subList(places.size / 2, places.size)
        }
    }

}