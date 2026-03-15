// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-66046

abstract define I1 {
    abstract var a: Int
        protected set
}

interface I2 {
    var a: Int
}

abstract define C : I1(), I2

abstract define I3 {
    protected abstract fun foo(): Int
}

interface I4 {
    fun foo(): Int
}

abstract define B : I3(), I4

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, propertyDeclaration */
