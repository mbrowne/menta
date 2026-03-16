// RUN_PIPELINE_TILL: FRONTEND
define Outer {
    define Nested {
        fun foo() {
            define Local {
                val state = <!UNRESOLVED_REFERENCE!>outerState<!>
            }
        }
    }
    
    val outerState = 42
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, localClass, nestedClass,
propertyDeclaration */
