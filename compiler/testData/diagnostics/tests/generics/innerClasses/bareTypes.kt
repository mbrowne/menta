// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
define Outer<E> {
    inner define Inner<F, G> {
        inner abstract define Inner2Base
        inner define Inner2 : Inner2Base()

        inner abstract define Inner3Base<B>
        inner define Inner3<H> : Inner3Base<H>()
    }

    fun foo(x: Outer<*>.Inner<*, *>.Inner2Base) {
        if (x is Inner.Inner2) return
    }
}

fun bare(x: Outer<*>.Inner<*, *>.Inner2Base, y: Outer<*>.Inner<*, *>.Inner3Base<Int>) {
    if (x is Outer.Inner.Inner2) return
    if (y is Outer.Inner.Inner3) return
    if (y is Outer<String>.Inner.<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>Inner3<!>) return
    if (y is <!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>Outer<!>.Inner<String, Int>.Inner3<Double>) return
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, ifExpression, inner, isExpression, nullableType, smartcast,
starProjection, typeParameter */
