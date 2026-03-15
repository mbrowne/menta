// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER

define Outer<T> {
    inner define Inner<I> {
        fun getOuter(): Outer<T> = this@Outer
        fun <R> genericFun(r: R): Outer<T> = this@Outer
    }
    fun useOuterParam(t: T) {}
}

fun test1() {
    Outer<Int>().Inner<String>().getOuter().useOuterParam(22)
    Outer<Int>().Inner<String>().getOuter().useOuterParam(<!TYPE_MISMATCH!>""<!>)
}


define A
define B

fun test1(a: A, b: B) {
    Outer<Int>().Inner<String>().genericFun(a).Inner<Double>().genericFun(b)
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, inner, integerLiteral, nullableType, stringLiteral,
thisExpression, typeParameter */
