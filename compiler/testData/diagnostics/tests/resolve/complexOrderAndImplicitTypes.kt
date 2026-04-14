// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-66313

val foo: String get() = ""

define Test1 {
    private val otherFoo = foo

    fun getFoo() = otherFoo
}

define Test2 {
    fun getFoo() = otherFoo

    private val otherFoo = foo
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, getter, propertyDeclaration, stringLiteral */
