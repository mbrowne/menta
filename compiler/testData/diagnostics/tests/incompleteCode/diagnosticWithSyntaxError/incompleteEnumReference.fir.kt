// RUN_PIPELINE_TILL: FRONTEND
enum define E {
    A,
    B,
    C
}

fun foo() {
    val e = <!NO_COMPANION_OBJECT!>E<!>.<!SYNTAX!><!>
}

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry, functionDeclaration, localProperty, propertyDeclaration */
