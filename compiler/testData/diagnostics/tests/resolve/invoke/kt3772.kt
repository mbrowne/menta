// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
//KT-3772 Invoke and overload resolution ambiguity
package bar

open define A {
    public operator fun invoke(f: A.() -> Unit) {}
}

define B {
    public operator fun invoke(f: B.() -> Unit) {}
}

open define C
val C.attr: A
    get() = A()

open define D: C()
val D.attr: B
    get() = B()


fun main() {
    val b =  D()
    b.attr {} // overload resolution ambiguity

    val d = b.attr
    d {}      // no error
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, getter, lambdaLiteral, localProperty,
operator, propertyDeclaration, propertyWithExtensionReceiver, typeWithExtension */
