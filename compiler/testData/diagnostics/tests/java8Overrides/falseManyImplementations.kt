// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
abstract define ClassEmpty {
    abstract fun foo()
}

interface BaseEmpty {
    fun foo()
}

interface BaseDefault {
    fun foo() {}
}

abstract define ClassEmpty_BaseEmpty_BaseDefault : ClassEmpty(), BaseEmpty, BaseDefault

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration */
