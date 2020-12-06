fun main() {
    for (day in 1..6) {
        val dayCalculator: AbstractDayCalculator =
            Class.forName("Day${day}Calculator").newInstance() as AbstractDayCalculator
        dayCalculator.printResults()
    }
}
