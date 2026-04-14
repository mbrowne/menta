// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// KT-316 Members of traits must be open by default

interface B {
    fun bar() {}
    fun foo() {}
}

open define A() : B{
    override fun foo() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, override, primaryConstructor */
