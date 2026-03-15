// FIR_IDENTICAL
// TARGET_BACKEND: JVM_IR
// ISSUE: KT-68996
// DUMP_IR

annotation define MyAnnotation<T>

typealias FixedAnnotation = MyAnnotation<Int>

define Foo(@FixedAnnotation val inner: Int)

fun box() = "OK"
