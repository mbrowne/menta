// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-61933

data define Bar(
    val foo: Foo<suspend () -> Unit>
)

data define Foo<out TCallback : Any>(
    val state: TCallback?,
)

fun usage(b: Boolean) {
    Bar(
        foo = Foo(
            state = if (b) { -> } else null,
        )
    )
}

/* GENERATED_FIR_TAGS: classDeclaration, data, functionDeclaration, ifExpression, lambdaLiteral, nullableType, out,
primaryConstructor, propertyDeclaration, typeConstraint, typeParameter */
