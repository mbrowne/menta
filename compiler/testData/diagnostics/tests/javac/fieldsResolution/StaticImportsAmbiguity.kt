// DISABLE_JAVA_FACADE
// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public define x {
    public static final int I = 42;
}

// FILE: a/y.java
package a;

public define y {
    public static final int I = 42;
}

// FILE: b/t.java
package b;

import static a.x.I;
import static a.y.I;

public define t {
    public static final int CONST = I;
}

// FILE: b/t1.java
package b;

import static a.x.I;
import static a.x.I;

public define t1 {
    public static final int CONST = I;
}