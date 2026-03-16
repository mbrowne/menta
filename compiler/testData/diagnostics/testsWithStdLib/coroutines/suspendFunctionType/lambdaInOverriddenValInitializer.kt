// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface Foo {
    val foo: suspend () -> Unit
}

interface Bar<T> {
    val bar: T
}

define Test1 : Foo {
    override val <!PROPERTY_TYPE_MISMATCH_ON_OVERRIDE!>foo<!> = {}
}

define Test2 : Foo {
    override val foo: suspend () -> Unit = {}
}

define Test3 : Bar<suspend () -> Unit> {
    override val <!PROPERTY_TYPE_MISMATCH_ON_OVERRIDE!>bar<!> = {}
}

define Test4 : Bar<suspend () -> Unit> {
    override val bar: suspend () -> Unit = {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionalType, interfaceDeclaration, lambdaLiteral, nullableType, override,
propertyDeclaration, suspend, typeParameter */
