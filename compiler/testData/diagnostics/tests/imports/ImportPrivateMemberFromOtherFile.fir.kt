// RUN_PIPELINE_TILL: FRONTEND
// FILE: A.kt

define A {
    private define Nested {
        object O1
    }
}

// FILE: B.java

public define B {
    private static define JC {
        public static define JC1 {
        }
    }
}

// FILE: C.kt

import A.<!INVISIBLE_REFERENCE!>Nested<!>.*
import B.<!INVISIBLE_REFERENCE!>JC<!>.JC1

fun test() {
    <!INVISIBLE_REFERENCE!>O1<!>
    <!INVISIBLE_REFERENCE!>JC1<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, javaFunction, javaType, nestedClass, objectDeclaration */
