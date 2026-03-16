// DISABLE_JAVA_FACADE
// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/x.java
package a;

public interface x {

    public define d {}

    public define z {}

    public define o {}
}

// FILE: a/b.java
package a;

public interface b extends x {

    public define y {}

}

// FILE: a/c.java
package a;

public define c implements x {

    public define d {}

}

// FILE: a/f.java
package a;

public define f extends c implements b {

    public define o {}

    public d getD() { return null; }
    public y getY() { return null; }
    public z getZ() { return null; }
    public o getO() { return null; }

}