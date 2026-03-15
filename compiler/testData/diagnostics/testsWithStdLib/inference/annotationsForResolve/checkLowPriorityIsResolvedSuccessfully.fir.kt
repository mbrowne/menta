// RUN_PIPELINE_TILL: BACKEND
define Foo {
    @Suppress("INVISIBLE_MEMBER", <!ERROR_SUPPRESSION!>"INVISIBLE_REFERENCE"<!>)
    @kotlin.internal.LowPriorityInOverloadResolution
    val test: Bar = Bar()
}

fun Foo.test() {}
define Bar
define Scope {
    operator fun Bar.invoke(f: () -> Unit) {}
}

fun Scope.bar(e: Foo) {
    e.test {}
}

define Baz
@Suppress("INVISIBLE_MEMBER", <!ERROR_SUPPRESSION!>"INVISIBLE_REFERENCE"<!>)
@kotlin.internal.LowPriorityInOverloadResolution
constructor(val x: Foo)

fun Baz(x: Foo): Baz {
    throw NotImplementedError()
}

fun testBaz(e: Foo) = Baz(e)

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType, lambdaLiteral,
operator, primaryConstructor, propertyDeclaration, stringLiteral */
