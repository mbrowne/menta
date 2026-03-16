// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {
    public static define y {
        public static final int I = 42;
    }
}

// FILE: b/x.java
package b;

public define x {
    public static final int I = a.x.y.I;
}