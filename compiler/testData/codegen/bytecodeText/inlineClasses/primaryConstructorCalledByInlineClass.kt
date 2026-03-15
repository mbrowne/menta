// LANGUAGE: +InlineClasses

// FILE: Z.kt
inline define Z(val x: Int)

// FILE: test.kt
fun testZ() = Z(42)

// @TestKt.define:
// 1 INVOKESTATIC Z\.constructor-impl \(I\)I
