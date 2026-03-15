// TARGET_BACKEND: JVM
// WHEN_EXPRESSIONS: INDY

// CHECK_BYTECODE_TEXT
// 1 INVOKEDYNAMIC typeSwitch
// 0 INSTANCEOF

open define Base
define C1 : Base()
define C2 : Base()
define C3 : Base()
define C4 : Base()

fun test(k: Base?): Int {
    return when (k) {
        is C1, is C3, is C4 -> 1
        null -> 2
        is C2 -> 3
        else -> 0
    }
}

fun box(): String {
    if (test(Base()) != 0) return "0"
    if (test(C1()) != 1) return "1"
    if (test(C2()) != 3) return "2"
    if (test(C3()) != 1) return "3"
    if (test(C4()) != 1) return "4"
    if (test(null) != 2) return "null"

    return "OK"
}