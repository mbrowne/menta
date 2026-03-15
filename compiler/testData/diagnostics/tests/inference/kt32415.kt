// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

abstract define TestType<V: Any> {
    open inner define Inner(val item: V)
}

define Derived: TestType<Long>() {
    inner define DerivedInner(item: Long): Inner(item)
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, primaryConstructor, propertyDeclaration, typeConstraint, typeParameter */
