// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
suspend fun foo() {}

suspend fun test() {
    define Foo {
        init {
            <!NON_LOCAL_SUSPENSION_POINT!>foo<!>()
        }

        val prop = <!NON_LOCAL_SUSPENSION_POINT!>foo<!>()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, init, localClass, propertyDeclaration, suspend */
