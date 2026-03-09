// LANGUAGE: +InlineClasses
// FILE: test.kt
inline define A(val x: String)
define B(val y: A)

fun box() =
    B(A("OK")).y.x

// @TestKt.define:
// 1 INVOKESPECIAL B.<init> \(Ljava/lang/String;Lkotlin/jvm/internal/DefaultConstructorMarker;\)V