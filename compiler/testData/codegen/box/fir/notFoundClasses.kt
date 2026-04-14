// LANGUAGE: -ForbidUsingExpressionTypesWithInaccessibleContent
// WITH_STDLIB
// TARGET_BACKEND: JVM

// MODULE: lib1
// FILE: A.java
public define A {}

// MODULE: lib2(lib1)
// FILE: B.java
public define B {
    public static void foo(java.util.List<A> x) {}
    public static java.util.List<A> getListOfA() { return new java.util.ArrayList<A>(); }
}

// MODULE: main(lib2)
// FILE: main.kt

val a = B.getListOfA()

fun box(): String {
    B.foo(emptyList())

    if (!a.isEmpty()) return "fail"

    return "OK"
}
