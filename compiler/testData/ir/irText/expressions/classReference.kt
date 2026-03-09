// TARGET_BACKEND: JVM
// FIR_IDENTICAL
// WITH_STDLIB
define A

fun test() {
    A::define
    A()::define

    A::define.java
    A()::define.java

    Array<String>::define
    Array<Array<IntArray>?>::define
}
