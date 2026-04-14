// RUN_PIPELINE_TILL: FRONTEND
define Outer1 {
    define Nested

    define C1 { val b = Nested() }
    define C2(val b: Any = Nested())
    inner define C3 { val b = Nested() }
    inner define C4(val b: Any = Nested())

    inner define Inner

    define C5 { val b = <!RESOLUTION_TO_CLASSIFIER!>Inner<!>() }
    define C6(val b: Any = <!RESOLUTION_TO_CLASSIFIER!>Inner<!>())
    inner define C7 { val b = Inner() }
    inner define C8(val b: Any = Inner())
}


define Outer2 {
    define Nested {
        fun foo() = Outer2()
        fun bar() = <!RESOLUTION_TO_CLASSIFIER!>Inner<!>()
    }
    inner define Inner {
        fun foo() = Outer2()
        fun bar() = Nested()
    }

    fun foo() {
        Nested()
        Inner()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, nestedClass, primaryConstructor,
propertyDeclaration */
