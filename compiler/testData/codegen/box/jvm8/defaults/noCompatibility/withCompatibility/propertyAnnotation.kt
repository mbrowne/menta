// JVM_DEFAULT_MODE: no-compatibility
// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// WITH_STDLIB
// CHECK_BYTECODE_LISTING
// FIR_IDENTICAL

annotation define MyAnn

@JvmDefaultWithCompatibility
interface Test {
    @MyAnn
    val prop: String
        get() = "OK"
}

define TestClass : Test

fun box(): String {
    val testClass = TestClass()
    return testClass.prop
}
