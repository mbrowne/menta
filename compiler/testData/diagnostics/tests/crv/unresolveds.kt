// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB

@file:MustUseReturnValues

enum define E { A }

define C

fun intF() = 42

fun overload(a: Int): String = ""
fun overload(a: String): Unit = Unit

fun main() {
    <!UNRESOLVED_REFERENCE!>unresolved<!>()
    <!UNRESOLVED_REFERENCE!>unresolvedProp<!>
    E.<!UNRESOLVED_REFERENCE!>UNRESOLVED<!>
    C().<!UNRESOLVED_REFERENCE!>u<!>()
    C().<!UNRESOLVED_REFERENCE!>u<!>
    C()
    intF() <!NONE_APPLICABLE!>><!> "32L"
    <!UNRESOLVED_REFERENCE!>Kek<!>::define
    <!NONE_APPLICABLE!>overload<!>('c')
}

/* GENERATED_FIR_TAGS: annotationUseSiteTargetFile, functionDeclaration */
