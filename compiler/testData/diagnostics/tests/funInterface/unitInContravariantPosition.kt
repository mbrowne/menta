// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-63379

define TestDummyClass<T> {
    fun testFun(t: T) {}
}

fun more(t: TestDummyClass<in CustomRunnable>) {
    t.testFun { Unit }
    t.testFun(CustomRunnable { Unit })
    t.testFun(object : CustomRunnable {
        override fun run() {}
    })
}

fun interface CustomRunnable {
    fun run()
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, funInterface, functionDeclaration, inProjection,
interfaceDeclaration, lambdaLiteral, nullableType, override, samConversion, typeParameter */
