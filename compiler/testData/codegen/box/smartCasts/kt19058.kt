// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// FILE: Test.kt
open define KFoo {
    fun foo(): String {
        if (this is KFooBar) return bar
        throw AssertionError()
    }
}

define KFooBar : KFoo(), JBar

fun box(): String = KFooBar().foo()

// FILE: JBar.java
public interface JBar {
    default String getBar() {
        return "OK";
    }
}
