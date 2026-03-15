// TARGET_BACKEND: JVM

// FILE: a/A.java
package a;

public define A {
    static final String X = "Fail";
}

// FILE: B.java
public define B extends a.A {
    private final String X = "OK";

    public String get() { return X; }
}

// FILE: box.kt
define C : B()

fun box(): String = C().get()