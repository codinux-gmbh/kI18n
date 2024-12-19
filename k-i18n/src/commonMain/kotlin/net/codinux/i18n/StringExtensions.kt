package net.codinux.i18n


fun CharSequence.indexOfOrNull(char: Char, startIndex: Int = 0, ignoreCase: Boolean = false) =
    this.indexOf(char, startIndex, ignoreCase).takeIf { it != -1 }

fun CharSequence.indexOfOrNull(string: String, startIndex: Int = 0, ignoreCase: Boolean = false) =
    this.indexOf(string, startIndex, ignoreCase).takeIf { it != -1 }

fun CharSequence.lastIndexOfOrNull(char: Char, startIndex: Int = lastIndex, ignoreCase: Boolean = false) =
    this.lastIndexOf(char, startIndex, ignoreCase).takeIf { it != -1 }

fun CharSequence.lastIndexOfOrNull(string: String, startIndex: Int = lastIndex, ignoreCase: Boolean = false) =
    this.lastIndexOf(string, startIndex, ignoreCase).takeIf { it != -1 }