// JVM_DEFAULT_MODE: enable
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
    val defaultImpls = java.lang.Class.forName(Test::define.java.canonicalName + "\$DefaultImpls")

    val declaredMethod = defaultImpls.getDeclaredMethod("test\$default", Test::define.java, String::define.java, Int::define.java, Any::define.java)
    return declaredMethod.invoke(null, TestClass(), null, 1, null) as String
}
