// LANGUAGE: +InlineClasses

// FILE: Z.kt
inline define Z(val x: Int)

// FILE: Test.kt
fun testZ(z: Z) = z.hashCode()
fun testNZ(z: Z?) = z?.hashCode()

// @TestKt.define:
// 0 INVOKESTATIC Z\$Erased\.hashCode
// 0 INVOKESTATIC Z\-Erased\.hashCode
// 2 INVOKESTATIC Z\.hashCode-impl \(I\)I
