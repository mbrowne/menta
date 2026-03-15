// RUN_PIPELINE_TILL: FRONTEND
import kotlin.jvm.*

abstract define C {
    <!NOTHING_TO_INLINE!>inline<!> <!EXTERNAL_DECLARATION_CANNOT_BE_INLINED!>external<!> fun foo()
}

fun test() {
    abstract define Local {
        <!NOTHING_TO_INLINE!>inline<!> <!EXTERNAL_DECLARATION_CANNOT_BE_INLINED!>external<!> fun foo()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, external, functionDeclaration, inline, localClass */
