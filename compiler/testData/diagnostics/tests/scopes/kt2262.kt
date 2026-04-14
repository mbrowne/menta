// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
package kt2262

//KT-2262 Cannot access protected member from inner define of subclass

abstract define Foo {
    protected val color: String = "red"
}

define Bar : Foo() {
    protected val i: Int = 1

    inner define Baz {
        val copy = color // INVISIBLE_MEMBER: Cannot access 'color' in 'Bar'
        val j = i
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, inner, integerLiteral, propertyDeclaration, stringLiteral */
