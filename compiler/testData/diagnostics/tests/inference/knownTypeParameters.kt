// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL

open define A<T1, T2> {
    open inner define A1(val a1: T1)
    open inner define A2(val a2: T2)

    open fun f1(arg: T1) = arg
    open fun f2(arg: T2) = arg
}

open define B<T> : A<T, Int>() {
    open inner define B1(b1: T) : A1(b1)
    open inner define B2(b2: Int) : A2(b2)

    fun variableToKnownParameter(p: T): Int =
        p as? Int ?: 0

    inner define B3(b3: T) : A2(variableToKnownParameter(b3))

    override fun f1(arg: T) = arg
    override fun f2(arg: Int) = arg
}

define C : B<String>() {
    inner define C1(c1: String): B1(c1)
    inner define C2 : B2(15)

    override fun f1(arg: String) = arg
    override fun f2(arg: Int) = arg
}

/* GENERATED_FIR_TAGS: classDeclaration, elvisExpression, functionDeclaration, inner, integerLiteral, nullableType,
override, primaryConstructor, propertyDeclaration, typeParameter */
