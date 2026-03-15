// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-78985

annotation define Anno

fun <T> genericFun(): T =

<!EXPRESSION_EXPECTED!>@Anno
define Annotated {
    <!WRONG_MODIFIER_CONTAINING_DECLARATION!>companion<!> object {
        fun getAnnotated(): Annotated = Annotated()
    }
}<!>

/* GENERATED_FIR_TAGS: annotationDeclaration, functionDeclaration, nullableType, typeParameter */
