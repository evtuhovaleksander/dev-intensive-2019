package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val components = fullName?.split(" ")
        val firstName = components?.elementAtOrNull(0)?.ifBlank { null }
        val lastName = components?.elementAtOrNull(1)?.ifBlank { null }
        return firstName to lastName
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        val strippedFirstName = firstName?.ifBlank { null }?.first()?.toUpperCase()
        val strippedLastName = lastName?.ifBlank { null }?.first()?.toUpperCase()
        val result = "${strippedFirstName ?: ""}${strippedLastName ?: ""}"
        return result.ifBlank { null }
    }

    fun transliteration(payload: String, divider: String = " "): String {
        var output = ""
        for (char in payload) {
            output += transliterateChar(char)
        }
        return output.replace(" ", divider)
    }

    fun transliterateChar(char: Char): String {
        var output = ""
        when (char.toString().toLowerCase()) {
            "а" -> output = "a"
            "б" -> output = "b"
            "в" -> output = "v"
            "г" -> output = "g"
            "д" -> output = "d"
            "е" -> output = "e"
            "ё" -> output = "e"
            "ж" -> output = "zh"
            "з" -> output = "z"
            "и" -> output = "i"
            "й" -> output = "i"
            "к" -> output = "k"
            "л" -> output = "l"
            "м" -> output = "m"
            "н" -> output = "n"
            "о" -> output = "o"
            "п" -> output = "p"
            "р" -> output = "r"
            "с" -> output = "s"
            "т" -> output = "t"
            "у" -> output = "u"
            "ф" -> output = "f"
            "х" -> output = "h"
            "ц" -> output = "c"
            "ч" -> output = "ch"
            "ш" -> output = "sh"
            "щ" -> output = "sh'"
            "ъ" -> output = ""
            "ы" -> output = "i"
            "ь" -> output = ""
            "э" -> output = "e"
            "ю" -> output = "yu"
            "я" -> output = "ya"
            else -> output = char.toString()
        }
        if (char.isUpperCase()) {
            return output.capitalize()
        } else {
            return output
        }
    }
}

