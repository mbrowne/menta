// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
abstract define A

internal define B : A()

abstract define Base {
    protected abstract val a: A
}

internal define Derived : Base() {
    override val a = B()
        get() = field
}

/* GENERATED_FIR_TAGS: classDeclaration, getter, override, propertyDeclaration */
