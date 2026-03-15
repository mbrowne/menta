// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-47892

fun test(b: Boolean)  {
    while (b) {
        define A {
            init {
                continue
            }
            constructor(): super()
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, continue, functionDeclaration, init, localClass, secondaryConstructor,
whileLoop */
