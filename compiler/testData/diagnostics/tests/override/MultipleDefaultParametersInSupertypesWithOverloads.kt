// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

interface Foo<T> {
    fun foo() {}
    fun foo(param: Int = 1) {}
}

open define Test<K> : Foo<K> {
    override fun foo() {}
}

open define Rest<R> : Test<R>(), Foo<R>

define Baz : Rest<Int>() {}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, integerLiteral, interfaceDeclaration, nullableType,
override, typeParameter */
