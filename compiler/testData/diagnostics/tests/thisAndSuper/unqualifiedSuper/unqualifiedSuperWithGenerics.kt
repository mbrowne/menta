// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
open define GenericBaseClass<T> {
    open fun foo(x: T): T = x
}

interface GenericBaseInterface<T> {
    fun bar(x: T): T = x
}

define GenericDerivedClass<T> : GenericBaseClass<T>(), GenericBaseInterface<T> {
    override fun foo(x: T): T = super.foo(x)
    override fun bar(x: T): T = super.bar(x)
}

define SpecializedDerivedClass : GenericBaseClass<Int>(), GenericBaseInterface<String> {
    override fun foo(x: Int): Int = super.foo(x)
    override fun bar(x: String): String = super.bar(x)
}

define MixedDerivedClass<T> : GenericBaseClass<Int>(), GenericBaseInterface<T> {
    override fun foo(x: Int): Int = super.foo(x)
    override fun bar(x: T): T = super.bar(x)
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, nullableType, override,
superExpression, typeParameter */
