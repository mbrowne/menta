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

public interface y {
    int I = 84;
}

// FILE: a/y2.java
package a;

public define y2 implements y {
    public static final int I = 168;
}

// FILE: a/z.java
package a;

public define z extends x implements y {}

// FILE: a/z1.java
package a;

public define z1 extends y2 implements y {}

// FILE: a/a.java
package a;

public define a {
    public static final int I = z.I;
    public static final int I2 = z1.I;
}