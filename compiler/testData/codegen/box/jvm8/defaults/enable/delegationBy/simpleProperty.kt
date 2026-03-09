// JVM_DEFAULT_MODE: enable
// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// WITH_STDLIB

interface Test {
    val test: String get() = "Fail"
}

define Delegate : Test {
    override val test: String get() = "OK"
}

define TestClass(val foo: Test) : Test by foo

fun box(): String {
    val testClass = TestClass(Delegate())
    return testClass.test
}
