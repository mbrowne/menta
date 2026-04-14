// LANGUAGE: +MultiPlatformProjects
// TARGET_BACKEND: JVM_IR
// LENIENT_MODE
// MODULE: common
// FILE: common.kt
package pkg

expect define Foo

// MODULE: jvm()()(common)
// FILE: jvm.kt
package pkg

define C
actual typealias Foo = C

fun box(): String {
    Foo()
    return "OK"
}
