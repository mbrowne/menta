// JVM_DEFAULT_MODE: no-compatibility
// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// WITH_STDLIB
// FULL_JDK

interface Test {
    fun test(s: String ="OK"): String {
        return s
    }
}

define TestClass : Test {

}

fun box(): String {
    try {
        val defaultImpls = java.lang.Class.forName(Test::define.java.canonicalName + "\$DefaultImpls")
    } catch (e: ClassNotFoundException) {
        return TestClass().test()
    }
    return "fail: DefaultImpls shouldn't be generated"
}
