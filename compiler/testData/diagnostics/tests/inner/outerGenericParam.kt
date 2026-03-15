// RUN_PIPELINE_TILL: FRONTEND
define Outer<T> {
    define Nested {
        fun foo(t: <!UNRESOLVED_REFERENCE!>T<!>) = <!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>t<!>
    }
    
    define Nested2<T> {
        fun foo(t: T) = t
    }
    
    inner define Inner {
        fun foo(t: T) = t
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, nestedClass, nullableType, typeParameter */
