class Day2Calculator : AdventCalculator {

    override fun calculatePart1(): Double {
        val text = this::class.java.getResourceAsStream("day2.txt").bufferedReader().readLines()
        var validPasswords = 0

        for (line in text) {
            val lineParts = line.split(": ")
            val policyParts = lineParts[0].split(" ")

            val charAmount = policyParts[0].split("-")
            val minAmount = charAmount[0].toInt()
            val maxAmount = charAmount[1].toInt()
            val characters = policyParts[1]
            val password = lineParts[1]

            if (isPasswordValidPart1(password, characters, minAmount, maxAmount)) {
                validPasswords++
            }
        }

        return validPasswords.toDouble()
    }

    override fun calculatePart2(): Double {
        val text = this::class.java.getResourceAsStream("day2.txt").bufferedReader().readLines()
        var validPasswords = 0

        for (line in text) {
            val lineParts = line.split(": ")
            val policyParts = lineParts[0].split(" ")

            val charAmount = policyParts[0].split("-")
            val index1 = charAmount[0].toInt()
            val index2 = charAmount[1].toInt()
            val characters = policyParts[1]
            val password = lineParts[1]

            if (isPasswordValidPart2(password, characters, index1, index2)) {
                validPasswords++
            }
        }

        return validPasswords.toDouble()
    }

    private fun isPasswordValidPart1(password: String, characters: String, minAmount: Int, maxAmount: Int): Boolean {
        val charAmount = password.split(characters).size - 1
        return charAmount in minAmount..maxAmount
    }

    private fun isPasswordValidPart2(password: String, characters: String, index1: Int, index2: Int): Boolean {
        var index: Int = password.indexOf(characters)
        val foundIndices = mutableListOf<Int>()
        while (index >= 0) {
            foundIndices.add(index + 1)
            index = password.indexOf(characters, index + 1)
        }
        return (foundIndices.contains(index1) && !foundIndices.contains(index2)) || (!foundIndices.contains(index1) && foundIndices.contains(
            index2
        ))
    }

}