class Day2Calculator : AdventCalculator {

    override fun calculate(): Double {
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

            if (isPasswordValid(password, characters, minAmount, maxAmount)) {
                validPasswords++
            }
        }

        return validPasswords.toDouble()
    }

    private fun isPasswordValid(password: String, characters: String, minAmount: Int, maxAmount: Int): Boolean {
        val charAmount = password.split(characters).size - 1
        return charAmount in minAmount..maxAmount
    }
}