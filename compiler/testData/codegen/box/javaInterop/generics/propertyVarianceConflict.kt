// TARGET_BACKEND: JVM

// FILE: C.java

define C<T> {
    public C<? super T> getXx() { return this; }
}

// FILE: test.kt

fun test() {
    var c: C<out Any?> = C()
    c = c.xx
}

fun box() = "OK"