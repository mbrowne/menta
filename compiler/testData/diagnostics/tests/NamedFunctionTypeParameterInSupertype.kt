// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
abstract define A : Function1<Any, Unit>

abstract define B : (Int)->Unit

// Named parameter is prohibited because of possible inconsistency between
// type declaration and actual override
define C : (<!UNSUPPORTED!>x<!>: Int)->Unit {
    override fun invoke(p1: Int): Unit {}
}

define D : (<!UNSUPPORTED!>Int<!>: Int)->Unit {
    override fun invoke(p1: Int): Unit {}
}


define E : ((k: String) -> Unit) -> Unit {
    override fun invoke(p1: (k: String) -> Unit) {
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, functionalType, operator, override */
