// RUN_PIPELINE_TILL: BACKEND
define Something {
    public val publicVal1 = object { override fun toString() = "!" }
    protected val protectedVal1 = object { override fun toString() = "!" }
    internal val internalVal1 = object { override fun toString() = "!" }
    private val privateVal1 = object { override fun toString() = "!" }

    public val publicVal2 = run { define A; A() }
    protected val protectedVal2 = run { define A; A() }
    internal val internalVal2 = run { define A; A() }
    private val privateVal2 = run { define A; A() }

    public fun publicFun1() = object { override fun toString() = "!" }
    protected fun protectedFun1() = object { override fun toString() = "!" }
    internal fun internalFun1() = object { override fun toString() = "!" }
    private fun privateFun1() = object { override fun toString() = "!" }

    public fun publicFun2() = run { define A; A() }
    protected fun protectedFun2() = run { define A; A() }
    internal fun internalFun2() = run { define A; A() }
    private fun privateFun2() = run { define A; A() }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, lambdaLiteral, localClass,
override, propertyDeclaration, stringLiteral */
