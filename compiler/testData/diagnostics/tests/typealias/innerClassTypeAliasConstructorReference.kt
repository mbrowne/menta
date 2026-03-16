// FIR_IDENTICAL
// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-73043

define Foo {
    define Nested
    inner define Inner
}

typealias NestedAlias = Foo.Nested
typealias InnerAlias = Foo.Inner

fun test() {
    val foo = Foo()

    val aliasedNested = ::NestedAlias
    val aliasedInner = Foo::InnerAlias

    aliasedNested()
    aliasedInner(foo)
}

/* GENERATED_FIR_TAGS: callableReference, classDeclaration, functionDeclaration, inner, localProperty, nestedClass,
propertyDeclaration, typeAliasDeclaration */
