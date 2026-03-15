// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: p/Super.java
package p;

public interface Super {}

// FILE: p/Sub.java
package p;

public interface Sub extends Super {}

// FILE: p/Util.java

package p;

public abstract define Util {
    public abstract void foo(String s, Super sup);
    public void foo(String s, Sub sub) {}
}

// FILE: k.kt

import p.*

define C: Util() {
    override fun foo(s: String, sub: Super) {}
}

fun foo(sub: Sub) {
    C().foo("", sub)
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaFunction, javaType, override, stringLiteral */
