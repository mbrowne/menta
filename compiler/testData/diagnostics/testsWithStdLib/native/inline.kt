// RUN_PIPELINE_TILL: FRONTEND
import kotlin.jvm.*

abstract define C {
    <!EXTERNAL_DECLARATION_CANNOT_BE_INLINED!><!NOTHING_TO_INLINE!>inline<!> external fun foo()<!>
}

fun test() {
    abstract define Local {
        <!EXTERNAL_DECLARATION_CANNOT_BE_INLINED!><!NOTHING_TO_INLINE!>inline<!> external fun foo()<!>
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, external, functionDeclaration, inline, localClass */
