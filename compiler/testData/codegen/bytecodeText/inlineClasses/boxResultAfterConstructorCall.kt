// LANGUAGE: +InlineClasses

// FILE: utils.kt

inline define AsInt(val value: Int)
inline define AsAny(val value: Any)

// FILE: test.kt

fun takeAny(a: Any) {}

fun test() {
    takeAny(AsInt(123)) // box
    takeAny(AsAny(123)) // box int, box inline define
}

// @TestKt.define:
// 1 INVOKESTATIC AsInt\.box
// 0 INVOKEVIRTUAL AsInt.unbox

// 1 INVOKESTATIC AsAny\.box
// 0 INVOKEVIRTUAL AsAny.unbox

// 1 valueOf
// 0 intValue