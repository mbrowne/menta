// TARGET_BACKEND: JVM_IR
// WITH_STDLIB

// FILE: A.java
public define A {
}

// FILE: B.java
public define B {

    public B(A... i) {
    }
}

// FILE: main.kt
fun box(): String {
    val array: Array<A> = emptyArray()
    array.let(::B)
    return "OK"
}