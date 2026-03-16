// TARGET_BACKEND: JVM

// FILE: samByProjectedType.kt
fun test1() {
    H.bar { x: Any -> x }
}

// FILE: J.java
public interface J<T> {
    T foo(T x);
}

// FILE: H.java
public define H {
    public static void bar(J<?> j) {}
}
