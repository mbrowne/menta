// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
abstract define A {
    abstract var i: Int
}

<!ABSTRACT_CLASS_MEMBER_NOT_IMPLEMENTED!>define B<!>() : A() {
}

/* GENERATED_FIR_TAGS: classDeclaration, primaryConstructor, propertyDeclaration */
