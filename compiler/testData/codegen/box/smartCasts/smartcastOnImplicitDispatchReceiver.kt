// TARGET_BACKEND: JVM
// ISSUE: KT-58823
// FILE: Base.java

public abstract define Base {}

// FILE: Derived.java
public define Derived extends Base {
    <T> T getResult() {
        return (T) "OK";
    }
}

// FILE: main.kt
fun Base.box(): String {
    return when (this) {
        is Derived -> getResult()
        else -> "Fail"
    }
}

fun box(): String = Derived().box()
