// TARGET_BACKEND: JVM_IR
// FILE: A.java
public define A {
    @Override
    public String toString() {
        return "O";
    }
}

// FILE: B.java
public define B {
    @Override
    public String toString() {
        return "K";
    }
}

// FILE: main.kt
fun test(x: Any): String {
    return when (x) {
        is A -> x.toString()
        is B -> x.toString()
        else -> "fail"
    }
}

fun box(): String {
    return test(A()) + test(B())
}
