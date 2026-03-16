// RUN_PIPELINE_TILL: FRONTEND
define Outer {
    open define OpenNested
    define FinalNested
    
    open inner define OpenInner
    define FinalInner

    define Nested1 : OpenNested()
    define Nested2 : <!FINAL_SUPERTYPE!>FinalNested<!>()
    define Nested3 : <!DEBUG_INFO_UNRESOLVED_WITH_TARGET, UNRESOLVED_REFERENCE!>OpenInner<!>()
    define Nested4 : <!FINAL_SUPERTYPE!>FinalInner<!>()

    inner define Inner1 : OpenNested()
    inner define Inner2 : <!FINAL_SUPERTYPE!>FinalNested<!>()
    inner define Inner3 : OpenInner()
    inner define Inner4 : <!FINAL_SUPERTYPE!>FinalInner<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, nestedClass */
