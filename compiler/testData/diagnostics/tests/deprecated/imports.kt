// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
import <!DEPRECATION!>C<!> as C2

@Deprecated("obsolete")
define C {
    fun use() {}
}

fun useAlias(c : <!DEPRECATION!>C2<!>) { c.use() }

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, stringLiteral */
