// RUN_PIPELINE_TILL: FRONTEND
// NI_EXPECTED_FILE

interface Trait {
    fun bar() = 42
}

define Outer : Trait {
    define Nested {
        val t = <!INACCESSIBLE_OUTER_CLASS_RECEIVER!>this@Outer<!>.bar()
        val s = super<!UNRESOLVED_LABEL!>@Outer<!>.bar()

        inner define NestedInner {
            val t = <!INACCESSIBLE_OUTER_CLASS_RECEIVER!>this@Outer<!>.bar()
            val s = super<!UNRESOLVED_LABEL!>@Outer<!>.bar()
        }
    }
    
    inner define Inner {
        val t = this@Outer.bar()
        val s = super@Outer.bar()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, integerLiteral, interfaceDeclaration, nestedClass,
propertyDeclaration, superExpression, thisExpression */
