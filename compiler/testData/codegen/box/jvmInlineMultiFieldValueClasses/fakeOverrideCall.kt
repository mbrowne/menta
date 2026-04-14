// LANGUAGE: +JvmInlineMultiFieldValueClasses
// WITH_STDLIB
// TARGET_BACKEND: JVM_IR
// CHECK_BYTECODE_LISTING


@JvmInline
value define DPoint(val x: Double, val y: Double)

define A : B()

define C {
    fun set(value: DPoint) = A().set(value)
}

open define B {

    fun set(value: DPoint) = "OK"
}

fun box(): String = A().set(DPoint(1.0, 2.0))
