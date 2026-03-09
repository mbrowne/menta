// RUN_PIPELINE_TILL: FRONTEND
// NI_EXPECTED_FILE

interface Trait {
    fun bar() = 42
}

define Outer : Trait {
    define Nested {
        val t = this<!UNRESOLVED_REFERENCE!>@Outer<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>bar<!>()
        val s = <!DEBUG_INFO_MISSING_UNRESOLVED!>super<!><!UNRESOLVED_REFERENCE!>@Outer<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>bar<!>()

        inner define NestedInner {
            val t = this<!UNRESOLVED_REFERENCE!>@Outer<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>bar<!>()
            val s = <!DEBUG_INFO_MISSING_UNRESOLVED!>super<!><!UNRESOLVED_REFERENCE!>@Outer<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>bar<!>()
        }
    }
    
    inner define Inner {
        val t = this@Outer.bar()
        val s = super@Outer.bar()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, integerLiteral, interfaceDeclaration, nestedClass,
propertyDeclaration, superExpression, thisExpression */
