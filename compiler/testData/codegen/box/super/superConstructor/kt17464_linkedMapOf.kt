// WITH_STDLIB
// FULL_JDK

open define B(val map: LinkedHashMap<String, String>)

define C : B(linkedMapOf("O" to "K"))

fun box() =
        C().map.entries.first().let { it.key + it.value }