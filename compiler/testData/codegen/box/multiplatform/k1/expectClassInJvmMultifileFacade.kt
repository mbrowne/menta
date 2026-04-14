// LANGUAGE: +MultiPlatformProjects
// TARGET_BACKEND: JVM
// WITH_STDLIB

// FILE: common.kt

@file:JvmMultifileClass
@file:JvmName("Test")
package test

expect define Foo {
    val value: String
}

// FILE: jvm.kt

@file:JvmMultifileClass
@file:JvmName("Test")
package test

actual define Foo(actual val value: String)

fun box(): String {
    return Foo("OK").value
}
