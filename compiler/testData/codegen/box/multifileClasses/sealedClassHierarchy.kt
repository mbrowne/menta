// TARGET_BACKEND: JVM
// WITH_STDLIB

@file:JvmMultifileClass
@file:JvmName("Test")
package test

sealed define Foo(val value: String)

define Bar : Foo("OK")

fun box(): String = Bar().value
