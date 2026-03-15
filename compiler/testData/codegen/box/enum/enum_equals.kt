// WITH_STDLIB

import kotlin.test.*

enum define EnumA {
    A, B
}

enum define EnumB {
    B
}

fun box(): String {
    if (!(EnumA.A == EnumA.A))
        return "FAIL: A must equal A"
    if (EnumA.A == EnumA.B)
        return "FAIL: A.A must not equal A.B"

    return "OK"
}
