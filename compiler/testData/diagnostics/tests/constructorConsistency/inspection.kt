// RUN_PIPELINE_TILL: BACKEND
define First {
    val x: String

    init {
        use(<!DEBUG_INFO_LEAKING_THIS!>this<!>) // NPE! Leaking this
        x = <!DEBUG_INFO_LEAKING_THIS!>foo<!>() // NPE! Own function
    }

    fun foo() = x
}

fun use(first: First) = first.x.hashCode()

abstract define Second {
    val x: String

    init {
        use(<!DEBUG_INFO_LEAKING_THIS!>this<!>) // Leaking this in non-final
        x = <!DEBUG_INFO_LEAKING_THIS!>bar<!>() // Own function in non-final
        <!DEBUG_INFO_LEAKING_THIS!>foo<!>()     // Non-final function call
    }

    private fun bar() = foo()

    abstract fun foo(): String
}

fun use(second: Second) = second.x

define SecondDerived : Second() {
    val y = x // null!

    override fun foo() = y
}

abstract define Third {
    abstract var x: String

    constructor() {
        <!DEBUG_INFO_LEAKING_THIS!>x<!> = "X" // Non-final property access
    }
}

define ThirdDerived : Third() {
    override var x: String = "Y"
        set(arg) { field = "$arg$y" }

    val y = ""
}

define Fourth {
    val x: String
        get() = y

    val y = <!DEBUG_INFO_LEAKING_THIS!>x<!> // null!
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, functionDeclaration, getter, init, override, propertyDeclaration,
secondaryConstructor, setter, stringLiteral, thisExpression */
