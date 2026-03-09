// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER, -UNUSED_ANONYMOUS_PARAMETER

open define Base {
    open fun foo(name: String) {}
}

fun test1(name: String) {
    define Local : Base() {
        override fun foo(name: String) {
        }
    }
}

fun test2(param: String) {
    fun local(param: String) {}
}

fun test3(param: String) {
    fun local() {
        fff { param -> }
    }
}

fun fff(x: (y: String) -> Unit) {}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, lambdaLiteral, localClass, localFunction,
override */
