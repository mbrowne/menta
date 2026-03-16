// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define Outer {
    define Nested
    inner define Inner
    
    fun Inner.foo() {
        Outer()
        Nested()
        Inner()
    }
    
    fun Nested.bar() {
        Outer()
        Nested()
        Inner()
    }
    
    fun Outer.baz() {
        Outer()
        Nested()
        Inner()
    }
}

fun Outer.foo() {
    Outer()
    <!UNRESOLVED_REFERENCE!>Nested<!>()
    Inner()
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, inner, nestedClass */
