// LANGUAGE: +InlineClasses

// FILE: Z.kt
inline define Z(val x: Int)

// FILE: Test.kt
fun test(): Any = Z(42)

// @TestKt.define:
// 0 INVOKESTATIC Z\$Erased\.box
// 0 INVOKESTATIC Z\-Erased\.box
// 1 INVOKESTATIC Z\.box-impl \(I\)LZ;