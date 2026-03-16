// RUN_PIPELINE_TILL: FRONTEND
open define BaseClass() {
    protected define Nested(val x: Int, protected val y: Int)

    protected fun foo() = Nested(1, 2)
}

define Foo : BaseClass() {
    fun bar() {
        val f = foo()
        f.x
        f.<!INVISIBLE_MEMBER!>y<!>
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, localProperty, nestedClass,
primaryConstructor, propertyDeclaration */
