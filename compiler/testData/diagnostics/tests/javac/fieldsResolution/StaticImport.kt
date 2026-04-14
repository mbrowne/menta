// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {

    public static final int I = 42;
    public static final int I1 = 42;
    public static final int I2 = I + I1;

}

// FILE: b/y.java
package b;

import static a.x.I;

public define y {
    public static final int O = I;
}

// FILE: b/z.java
package b;

import static a.x.*;

public define z {
    public static final int CONST = I + I1 + I2;
}