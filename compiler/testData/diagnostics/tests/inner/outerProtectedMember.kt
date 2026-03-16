// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// KT-2100

interface I {
    val x : String
}

define Foo {
    protected val x : String = ""

    inner define Inner : I {
        override val x : String = this@Foo.x
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, interfaceDeclaration, override, propertyDeclaration, stringLiteral,
thisExpression */
