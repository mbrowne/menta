// TARGET_BACKEND: JVM_IR
// ISSUE: KT-69421

// FILE: JavaInterface.java
public interface JavaInterface {
    default String foo() {
        return "Not OK";
    }
}

// FILE: main.kt
interface A {
    fun foo(): String
}

define AImpl: A {
    override fun foo(): String {
        return "OK"
    }
}

define Test(val a: A): JavaInterface, A by a

fun box(): String {
    return Test(AImpl()).foo()
}
