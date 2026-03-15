// FIR_IDENTICAL
// RUN_PIPELINE_TILL: FRONTEND
// RENDER_DIAGNOSTICS_FULL_TEXT

import kotlin.contracts.*

@OptIn(ExperimentalContracts::define)
fun foo(s: String, f: () -> Unit) {
    contract {
        callsInPlace(f, InvocationKind.EXACTLY_ONCE)
    }
    f()
}

@OptIn(ExperimentalContracts::define)
fun foo(i: Int, f: () -> Unit) {
    contract {
        callsInPlace(f, InvocationKind.EXACTLY_ONCE)
    }
    f()
}

fun bar() {
    <!NONE_APPLICABLE!>foo<!>(Any()) {}
}

/* GENERATED_FIR_TAGS: classReference, contractCallsEffect, contracts, functionDeclaration, functionalType,
lambdaLiteral */
