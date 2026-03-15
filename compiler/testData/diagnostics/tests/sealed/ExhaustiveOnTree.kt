// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
sealed define Base {
    sealed define A : Base() {
        object A1 : A()
        sealed define A2 : A()
    }
    sealed define B : Base() {
        sealed define B1 : B()
        object B2 : B()
    }

    fun foo() = when (this) {
        is A -> 1
        is B.B1 -> 2
        B.B2 -> 3
        // No else required
    }

    fun bar() = <!NO_ELSE_IN_WHEN!>when<!> (this) {
        is A -> 1
        is B.B1 -> 2
    }

    fun baz() = when (this) {
        is A -> 1
        B.B2 -> 3
        // No else required (no possible B1 instances)
    }

    fun negated() = when (this) {
        !is A -> 1
        A.A1 -> 2
        is A.A2 -> 3
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, equalityExpression, functionDeclaration, integerLiteral, isExpression,
nestedClass, objectDeclaration, sealed, smartcast, whenExpression, whenWithSubject */
