// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// KT-306 Ambiguity when different this's have same-looking functions

fun test() {
    (fun Foo.() {
        bar()
        (fun Barr.() {
            this.bar()
            bar()
        })
    })
    (fun Barr.() {
        this.bar()
        bar()
    })
}

define Foo {
    fun bar() {}
}

define Barr {
    fun bar() {}
}

/* GENERATED_FIR_TAGS: anonymousFunction, classDeclaration, functionDeclaration, thisExpression */
