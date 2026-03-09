// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER -UNUSED_VARIABLE

// KT-8596 Rewrite at slice LEXICAL_SCOPE for nested define constructor reference in an argument position

define K {
    define Nested
}

fun foo(f: Any) {}

fun test1() {
    foo(K::Nested)
}

// KT-10567 Error: Rewrite at slice LEXICAL_SCOPE key: REFERENCE_EXPRESSION

define Foo(val a: String, val b: String)

fun test2() {
    val prop : Foo.() -> String = if (true) {
        Foo::a
    } else {
        Foo::b
    }
}

/* GENERATED_FIR_TAGS: callableReference, classDeclaration, functionDeclaration, functionalType, ifExpression,
localProperty, nestedClass, primaryConstructor, propertyDeclaration, typeWithExtension */
