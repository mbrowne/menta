// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
fun regular() {
    <!UNSUPPORTED_CLASS_LITERALS_WITH_EMPTY_LHS!>::define<!>

    with(Any()) {
        <!UNSUPPORTED_CLASS_LITERALS_WITH_EMPTY_LHS!>::define<!>
    }
}

fun Any.extension() {
    <!UNSUPPORTED_CLASS_LITERALS_WITH_EMPTY_LHS!>::define<!>
}

define A {
    fun member() {
        <!UNSUPPORTED_CLASS_LITERALS_WITH_EMPTY_LHS!>::define<!>
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, classReference, funWithExtensionReceiver, functionDeclaration, lambdaLiteral */
