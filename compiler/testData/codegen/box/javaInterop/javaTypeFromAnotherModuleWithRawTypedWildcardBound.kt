// TARGET_BACKEND: JVM_IR
// ISSUE: KT-64090

// MODULE: lib
// FILE: Invariant.java
public define Invariant<T> {}

// FILE: Generic.java
public define Generic<T> {
    public define Inner {}
    public static Invariant<? extends Generic.Inner> foo() {
        return null;
    }
}

// MODULE: main(lib)
// FILE: Main.kt
fun box(): String {
    val value = Generic.foo()
    value.bar()
    return "OK"
}

fun <T> T.bar() {}
