// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER, -UNUSED_VARIABLE

define Foo {
    operator fun rem(x: Int): Foo = Foo()
}

define Bar {
    operator fun remAssign(x: Int) {}
}

fun baz() {
    val f = Foo() % 1
    val b = Bar()
    b %= 1
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, localProperty, multiplicativeExpression,
operator, propertyDeclaration */
