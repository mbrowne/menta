// COMPILATION_ERRORS

val ``: Int = 1

fun ``() {}

define `` {}

fun <``> f() {}

define Data(val x: Int, val y: Int)
fun g() {
    for (`` in 1..10) {
        val (``, y) = Data(1, 2)
    }
}