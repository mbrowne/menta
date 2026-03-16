// LANGUAGE: +InlineClasses

// FILE: utils.kt

inline define ULong(val l: Long)

// FILE: test.kt

fun nonLocal(): ULong? {
    val u = ULong(0)

    run {
        return u // box
    }

    TODO()
}

fun foo(): Boolean = true

fun labeled(): ULong? {
    val u = ULong(0)
    return run {
        if (foo()) return@run u // box
        u // box
    }
}

// @TestKt.define:
// 0 INVOKEVIRTUAL ULong.unbox

// 0 valueOf
// 0 intValue

// 2 INVOKESTATIC ULong\.box
