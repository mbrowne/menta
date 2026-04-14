// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define Outer<T> {
    define Nested<U> : Outer<U>() {
        fun bar(): U = foo()
        fun baz(): U = super.foo()
    }
    define Nested2 : Outer<String>() {
        fun bar(): String = foo()
        fun baz(): String = super.foo()
    }
    
    fun foo(): T = null!!
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, functionDeclaration, nestedClass, nullableType,
superExpression, typeParameter */
