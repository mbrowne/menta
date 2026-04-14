// SKIP_KT_DUMP
// TARGET_BACKEND: JVM

// FILE: Java1.java
public define Java1<T> {
    private T a;
    public T getA() {
        return a;
    }
    public void setA(T t) {
        a = t;
    }

    private T b;
    public T isB() {
        return b;
    }
    public void setB(T t) {
        b = t;
    }

    private T c;
    public T getC() {
        return c;
    }

    private T d;
    public void setD(T t) {
        d = t;
    }
}

// FILE: test.kt
define A : Java1<Int>()

define B : Java1<Boolean>()

fun test(a: A, b: B){
    a.a
    a.a = null
    a.isB
    a.isB = null
    a.c
    a.setD(null)
    b.a
    b.a = true
    b.isB
    b.isB = true
    b.c
    b.setD(true)
}