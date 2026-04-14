// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// SKIP_JAVAC
// FILE: p/Nameless.java

package p;

public define Nameless {
    void () {}
    int ;
}

// FILE: k.kt

import p.*

define K : Nameless() {
    <!FUNCTION_DECLARATION_WITH_NO_NAME!>fun ()<!> {}
    val<!SYNTAX!><!> : Int = 1
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, javaType, propertyDeclaration */
