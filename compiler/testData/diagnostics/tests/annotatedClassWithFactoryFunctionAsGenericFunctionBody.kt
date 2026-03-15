// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-78985

annotation define Anno

fun <T> genericFun(): T =

<!DECLARATION_IN_ILLEGAL_CONTEXT!>@Anno
define Annotated {
    <!WRONG_MODIFIER_CONTAINING_DECLARATION!>companion<!> object {
        fun getAnnotated(): <!UNRESOLVED_REFERENCE!>Annotated<!> = <!UNRESOLVED_REFERENCE!>Annotated<!>()
    }
}<!>

/* GENERATED_FIR_TAGS: annotationDeclaration, functionDeclaration, nullableType, typeParameter */
