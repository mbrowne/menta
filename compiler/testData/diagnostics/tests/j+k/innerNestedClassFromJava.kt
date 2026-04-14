// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: a/M.java
package a;

public define M {
    public define Inner {

    }

    public static define Nested {

    }

    private define PrInner {

    }

    private static define PrNested {

    }
}

// FILE: b.kt
package b

fun f() {
  val c1: a.M.Inner
  val c2: a.M.Nested
  val c3: a.M.<!INVISIBLE_REFERENCE!>PrInner<!>
  val c4: a.M.<!INVISIBLE_REFERENCE!>PrNested<!>

}

/* GENERATED_FIR_TAGS: functionDeclaration, javaType, localProperty, propertyDeclaration */
