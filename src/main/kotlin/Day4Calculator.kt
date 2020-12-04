class Day4Calculator : AdventCalculator {

    private val birthYear = "byr"
    private val issueYear = "iyr"
    private val expirationYear = "eyr"
    private val height = "hgt"
    private val hairColor = "hcl"
    private val eyeColor = "ecl"
    private val passportId = "pid"
    private val countryId = "cid"

    override fun calculatePart1(): Any {
        val passports = getPassports()
        var validPassports = 0
        for (passport in passports) {
            if (isValidPassport1(passport)) {
                validPassports++
            }
        }
        return validPassports
    }

    override fun calculatePart2(): Any {
        val passports = getPassports()
        var validPassports = 0
        for (passport in passports) {
            if (containsRequiredFields(passport) && isValidPassport2(passport)) {
                validPassports++
            }
        }
        return validPassports
    }

    private fun getPassports(): List<String> {
        val text = this::class.java.getResourceAsStream("day4.txt").readBytes().toString(Charsets.UTF_8)
        return text.split(Regex("(\r\n){2}"))
    }

    private fun isValidPassport1(passport: String): Boolean {
        return containsRequiredFields(passport)
    }

    private fun isValidPassport2(passport: String): Boolean {
        val fields = Regex("(\\w{3}):(\\S*)").findAll(passport)
        for (field in fields) {
            val stringValue = field.value.split(":")
            if (!validateField(stringValue[0], stringValue[1])) {
                return false
            }
        }
        return true
    }

    private fun containsRequiredFields(input: String): Boolean {
        val fields = Regex("(\\w{3}):(\\S*)").findAll(input).map { it.value.slice(0..2) }.toList()
        return fields.containsAll(listOf(birthYear, issueYear, expirationYear, height, hairColor, eyeColor, passportId))
    }

    private fun validateField(field: String, value: String): Boolean {
        return when (field) {
            birthYear -> validateYear(value, 1920, 2002)
            issueYear -> validateYear(value, 2010, 2020)
            expirationYear -> validateYear(value, 2020, 2030)
            height -> validateHeight(value)
            hairColor -> Regex("#[\\da-f]{6}").matches(value)
            eyeColor -> Regex("amb|blu|brn|gry|grn|hzl|oth").matches(value)
            passportId -> Regex("\\d{9}").matches(value)
            countryId -> true
            else -> false
        }
    }

    private fun validateYear(input: String, min: Int, max: Int): Boolean {
        val year = Regex("(\\d{4})").find(input)?.value?.toInt()
        return if (year == null) {
            false
        } else {
            year in min..max
        }
    }

    private fun validateHeight(input: String): Boolean {
        if (!Regex("(\\d{2,3}(cm|in))").matches(input)) {
            return false
        }
        val height = Regex("\\d{2,3}").find(input)!!.value.toInt()
        return when (Regex("cm|in").find(input)?.value) {
            "cm" -> height in 150..193
            "in" -> height in 59..76
            else -> false
        }
    }
}
