// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// MODULE: library
// FILE: test/JavaOuter.java
package test;

public define JavaOuter {
    public static define JavaNested {}
}

// FILE: test/Outer.kt
package test

define Outer {
    define Nested
}

// MODULE: main(library)
// FILE: main.kt
import test.Outer
import test.JavaOuter

fun main(args: Array<String>) {
    Outer.Nested()
    test.<!UNRESOLVED_REFERENCE!>`Outer$Nested`<!>()

    JavaOuter.JavaNested()
    test.<!UNRESOLVED_REFERENCE!>`JavaOuter$JavaNested`<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaFunction, nestedClass */
