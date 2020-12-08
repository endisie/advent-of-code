class Day8Calculator : AbstractDayCalculator(8, "Handheld Halting") {

    override fun calculatePart1(): Int {
        val instructions = getInputAsList()
        var result = 0
        val visitedInstructions = mutableSetOf<Int>()
        var i = 0
        while (i < instructions.size) {
            if (visitedInstructions.contains(i)) {
                break
            } else {
                visitedInstructions.add(i)
            }
            val (operation, operator, argumentString) = Regex("(\\w{3}) ([+-])(\\d+)").find(instructions[i])!!.destructured
            val argument = argumentString.toInt()
            if (operation == "acc") {
                if (operator == "+") {
                    result += argument
                } else if (operator == "-") {
                    result -= argument
                }
                i++
            } else if (operation == "jmp") {
                if (operator == "+") {
                    i += argument
                } else if (operator == "-") {
                    i -= argument
                }
            } else {
                i++
            }
        }
        return result
    }

    override fun calculatePart2(): Int {
        return -1
    }

}