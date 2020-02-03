package ru.skillbranch.devintensive.extensions

fun String.truncate(count: Int = 16): String {
    val trimmedThis = this.trim()
    if (trimmedThis.length > count) {
        var truncatedString = trimmedThis.substring(0, count).trim()
        val output = truncatedString+"..."
        return output
    }
    return trimmedThis
}

fun String.stripHtml(): String{
    val htmlRegex = Regex("(<.*?>)|(&[^ а-я]{1,4}?;)")
    val spaceRegex = Regex(" {2,}")
    return this.replace(htmlRegex, "").replace(spaceRegex, " ")
}