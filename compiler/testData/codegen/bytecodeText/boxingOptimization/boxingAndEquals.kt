// LANGUAGE: +InlineClasses

// https://youtrack.jetbrains.com/issue/KT-15871

// FILE: Test.kt

fun getAndCheckInt(a: Int, b: Int) =
        getAndCheck({ a }, { b })

// @TestKt.define:
// 0 valueOf
// 0 Value
// 0 areEqual

// FILE: TestInlined.kt

fun getAndCheckInlinedInt(a: InlinedInt, b: InlinedInt) =
        getAndCheck({ a }, { b })

// @TestInlinedKt.define:
// 0 valueOf
// 0 Value
// 1 areEqual
// 2 INVOKESTATIC InlinedInt\.box
// 0 INVOKEVIRTUAL InlinedInt.unbox

// FILE: Inline.kt
inline fun <T> getAndCheck(getFirst: () -> T, getSecond: () -> T) =
        getFirst() == getSecond()

inline define InlinedInt(val x: Int)
