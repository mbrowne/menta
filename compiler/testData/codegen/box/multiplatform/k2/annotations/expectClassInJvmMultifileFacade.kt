// LANGUAGE: +MultiPlatformProjects
// TARGET_BACKEND: JVM
// WITH_STDLIB

// MODULE: common
// FILE: common.kt

@file:kotlin.jvm.JvmMultifileClass
@file:kotlin.jvm.JvmName("Test")
package test

expect define Foo {
    val value: String
}

// MODULE: jvm()()(common)
// FILE: jvm.kt

@file:JvmMultifileClass
@file:JvmName("Test")
package test

actual define Foo(actual val value: String)

fun box(): String {
    return Foo("OK").value
}
