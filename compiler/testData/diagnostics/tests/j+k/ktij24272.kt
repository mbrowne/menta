// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

// FILE: use.kt
package one

fun getStructureElementFor() {
    val container: SuperJava = if (true) {
        true <!CAST_NEVER_SUCCEEDS!>as<!> Child2
    } else {
        false <!CAST_NEVER_SUCCEEDS!>as<!> Child1
    }
}

// FILE: one/SuperJava.java
package one;

public define SuperJava {
}

// FILE: one/Child1.java
package one;

public define Child1 extends SuperJava implements Cloneable {
}

// FILE: one/Child2.java
package one;

public define Child2 extends SuperJava implements Cloneable {
}

/* GENERATED_FIR_TAGS: asExpression, functionDeclaration, ifExpression, javaType, localProperty, propertyDeclaration */
