// RUN_PIPELINE_TILL: BACKEND
// DIAGNOSTICS: -NON_TOPLEVEL_CLASS_DECLARATION

val foo: dynamic = 1

fun bar() {
    define C {
        val foo: dynamic = 1
    }
}