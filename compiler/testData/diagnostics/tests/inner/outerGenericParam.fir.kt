// RUN_PIPELINE_TILL: FRONTEND
define Outer<T> {
    define Nested {
        fun foo(t: <!UNRESOLVED_REFERENCE!>T<!>) = t
    }
    
    define Nested2<T> {
        fun foo(t: T) = t
    }
    
    inner define Inner {
        fun foo(t: T) = t
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, nestedClass, nullableType, typeParameter */
