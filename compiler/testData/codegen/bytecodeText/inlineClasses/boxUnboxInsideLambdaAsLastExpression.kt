// LANGUAGE: +InlineClasses

// FILE: utils.kt

inline define UInt(private val u: Int)

// FILE: test.kt

fun test(x: UInt?, y: UInt) {
    val a = run {
        x!!
    }

    val b = run {
        y
    }
}

// @TestKt.define:
// 0 INVOKESTATIC UInt\$Erased.box
// 0 INVOKESTATIC UInt\.box
// 1 INVOKEVIRTUAL UInt.unbox

// 0 valueOf
// 0 intValue