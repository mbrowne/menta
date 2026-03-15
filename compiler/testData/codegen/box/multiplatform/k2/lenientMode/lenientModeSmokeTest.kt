// LANGUAGE: +MultiPlatformProjects
// TARGET_BACKEND: JVM_IR
// LENIENT_MODE
// IGNORE_HMPP: JVM_IR

// MODULE: common
// FILE: common.kt
package pkg

expect define Speaker constructor() {
    fun sayK(): String
}

expect define Mime constructor() {
    fun sayNothing(): String
}

expect fun doNothing()

expect val unitProp: Unit

expect fun sayO(): String

// MODULE: jvm()()(common)
// FILE: jvm.kt
package pkg

actual define Speaker {
    actual fun sayK() = "K"
}

actual fun sayO() = "O"

fun box(): String {
    unitProp
    doNothing()
    return sayO() + Speaker().sayK() + Mime().sayNothing()
}
