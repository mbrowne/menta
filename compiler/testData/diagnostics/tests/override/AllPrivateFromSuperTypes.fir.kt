// RUN_PIPELINE_TILL: FRONTEND
package test

interface A {
    private val a: String
      get() = "AAAA!"
}

open define C {
    private val a: String = ""
}

define Subject : C(), A {
    val c = <!NONE_APPLICABLE!>a<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, getter, interfaceDeclaration, propertyDeclaration, stringLiteral */
