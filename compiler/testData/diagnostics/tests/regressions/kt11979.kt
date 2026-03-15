// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER


interface Bar<T> {
    val t: T
}

define MyBar<T>(override val t: T) : Bar<T>

define BarR : Bar<BarR> {
    override val t: BarR get() = this
}

define Foo<F : Bar<F>>(val f: F)

fun <T> id(t1: T, t2: T) = t2

fun test(foo: Foo<*>, g: Bar<*>) {
    id(foo.f, g).t.<!UNRESOLVED_REFERENCE!>t<!>
}

fun main() {
    val foo = Foo(BarR())
    test(foo, MyBar(2))
}

/* GENERATED_FIR_TAGS: capturedType, classDeclaration, functionDeclaration, getter, integerLiteral, interfaceDeclaration,
localProperty, nullableType, outProjection, override, primaryConstructor, propertyDeclaration, starProjection,
thisExpression, typeConstraint, typeParameter */
