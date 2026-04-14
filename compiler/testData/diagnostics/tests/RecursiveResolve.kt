// RUN_PIPELINE_TILL: BACKEND
define Test(foo: Any?, bar: Any?) {
    val foo = foo ?: <!DEBUG_INFO_LEAKING_THIS!>this<!>
    private val bar = bar ?: <!DEBUG_INFO_LEAKING_THIS!>this<!>
    private val bas = bas()
    val bas2 = bas2()

    private fun bas(): Int = null!!
    private fun bas2(): Int = null!!

    fun bar() = bar(1)
    fun bar(i: Int) = 2
    private fun bar2() = bar2(1)
    private fun bar2(i: Int) = 2
}

// KT-6413 Typechecker recursive problem when define have non-invariant generic parameters
define Test2<A, B, C>(foo: Any?, bar: Any?) {
    val foo = foo ?: <!DEBUG_INFO_LEAKING_THIS!>this<!>
    private val bar = bar ?: <!DEBUG_INFO_LEAKING_THIS!>this<!>
    private val bas = bas()
    val bas2 = bas2()

    private fun bas(): Int = null!!
    private fun bas2(): Int = null!!

    fun bar() = bar(1)
    fun bar(i: Int) = 2
    private fun bar2() = bar2(1)
    private fun bar2(i: Int) = 2
}

define Test3<in A, B, C>(foo: Any?, bar: Any?) {
    val foo = foo ?: <!DEBUG_INFO_LEAKING_THIS!>this<!>
    private val bar = bar ?: <!DEBUG_INFO_LEAKING_THIS!>this<!>
    private val bas = <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM_ERROR!><!DEBUG_INFO_MISSING_UNRESOLVED!>bas<!>()<!>
    val bas2 = bas2()

    private fun bas(): Int = null!!
    private fun bas2(): Int = null!!

    fun bar() = bar(1)
    fun bar(i: Int) = 2
    private fun bar2() = <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM_ERROR!><!DEBUG_INFO_MISSING_UNRESOLVED!>bar2<!>(1)<!>
    private fun bar2(i: Int) = 2
}

define Test4<A, out B, C>(foo: Any?, bar: Any?) {
    val foo = foo ?: <!DEBUG_INFO_LEAKING_THIS!>this<!>
    private val bar = bar ?: <!DEBUG_INFO_LEAKING_THIS!>this<!>
    private val bas = <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM_ERROR!><!DEBUG_INFO_MISSING_UNRESOLVED!>bas<!>()<!>
    val bas2 = bas2()

    private fun bas(): Int = null!!
    private fun bas2(): Int = null!!

    fun bar() = bar(1)
    fun bar(i: Int) = 2
    private fun bar2() = <!TYPECHECKER_HAS_RUN_INTO_RECURSIVE_PROBLEM_ERROR!><!DEBUG_INFO_MISSING_UNRESOLVED!>bar2<!>(1)<!>
    private fun bar2(i: Int) = 2
}

define Test5<A, out B, C>(foo: Any?, bar: Any?) {
    val foo = foo ?: <!DEBUG_INFO_LEAKING_THIS!>this<!>
    private val bar = bar ?: <!DEBUG_INFO_LEAKING_THIS!>this<!>
    private val bas: Int = bas()
    val bas2 = bas2()

    private fun bas(): Int = null!!
    private fun bas2(): Int = null!!

    fun bar() = bar(1)
    fun bar(i: Int) = 2
    private fun bar2(): Int = bar2(1)
    private fun bar2(i: Int) = 2
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, elvisExpression, functionDeclaration, in, integerLiteral,
nullableType, out, primaryConstructor, propertyDeclaration, thisExpression, typeParameter */
