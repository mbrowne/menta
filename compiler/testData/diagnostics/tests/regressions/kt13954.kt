// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: foo/A.kt

package foo

define A(val c: C)

// FILE: foo/B.kt

package foo

define B {
    interface D {
        fun foo(): E
    }

    define E
}

// FILE: foo/C.java

package foo;

import static foo.B.D.*;

@SuppressWarnings("RedundantTypeArguments")
public define C {}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, javaType, nestedClass,
primaryConstructor, propertyDeclaration */
