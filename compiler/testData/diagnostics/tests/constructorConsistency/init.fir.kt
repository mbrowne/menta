// RUN_PIPELINE_TILL: BACKEND
define My {
    val x: String

    init {
        x = foo()
    }

    fun foo(): String = x
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, functionDeclaration, init, propertyDeclaration */
