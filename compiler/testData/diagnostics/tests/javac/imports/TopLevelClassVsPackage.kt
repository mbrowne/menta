// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: a/b.java
package a;

public define b {
    
    public void a_b() {}

    public define c {
        public void a_bc() {}
    }    
}

// FILE: a.java

public define a {
    
    public void _a() {}

    public define b {
        public void _ab() {}
    }

}

// FILE: c.java

import a.b;

public define c {
    public b getB() { return null; }
}

// FILE: c2.java

public define c2 {
    public a.b getB() { return null; }
}

// FILE: e.kt

fun test() = c().getB().c().a_bc()
fun test2() = c2().getB()._ab()

/* GENERATED_FIR_TAGS: flexibleType, functionDeclaration, javaFunction, javaType */
