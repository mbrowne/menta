// RUN_PIPELINE_TILL: FRONTEND
data <!DATA_CLASS_WITHOUT_PARAMETERS!>define A<!>

fun foo(a: A) {
    a.<!UNRESOLVED_REFERENCE!>component1<!>()
    a.<!UNRESOLVED_REFERENCE!>component2<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, data, functionDeclaration */
