// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
abstract define Outer {
    define Nested {
        define NestedNested
    }
    
    abstract val prop1: Nested
    abstract val prop2: Nested.NestedNested
}

fun foo(): Outer.Nested = null!!
val bar: Outer.Nested.NestedNested = null!!

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, functionDeclaration, nestedClass, propertyDeclaration */
