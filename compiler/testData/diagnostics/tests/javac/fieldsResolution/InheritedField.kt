// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {
    public static final int CONST = 42;
}

// FILE: a/y.java
package a;

public define y extends x {
    public static final int O = CONST;
}

// FILE: a/z.java
package a;

public define z {

    public static final int I = y.CONST;
    public static final int O = y.O;

}