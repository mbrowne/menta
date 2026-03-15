// TARGET_BACKEND: JVM
// IGNORE_BACKEND_K2: JVM_IR, JS_IR
// FIR status: scripts aren't supported yet
// WITH_STDLIB
// WITH_REFLECT

// FILE: test.kt

fun box(): String {
    val kClass = Script::define
    val nestedClasses = kClass.nestedClasses
    val nestedClass = nestedClasses.single()
    return nestedClass.simpleName!!
}


// FILE: Script.kts

define OK
typealias Tazz = List<OK>
val x: Tazz = listOf()
x
