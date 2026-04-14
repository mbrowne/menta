// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
abstract define A {
    abstract override fun toString(): String
}

interface B

abstract define C : A(), B

<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define Test<!> : C()

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, override */
