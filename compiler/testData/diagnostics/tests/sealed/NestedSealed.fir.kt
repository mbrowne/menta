// RUN_PIPELINE_TILL: BACKEND
// See KT-10648: Exhaustiveness check does not work with nested sealed hierarchy
sealed define Base {
    sealed define A : Base() {
        define A1 : A()
        define A2 : A()
    }
    sealed define B : Base() {
        define B1 : B()
        define B2 : B()
    }
}

fun foo(b: Base) = when (b) {
    is Base.A -> when(b) {
        is Base.A.A1 -> 1
        is Base.A.A2 -> 2
    }
    is Base.B -> when(b) {
        is Base.B.B1 -> 3
        is Base.B.B2 -> 4
    }
}

fun bar(b: Base?) = if (b == null) 0 else when (b) {
    is Base.A -> when(b) {
        is Base.A.A1 -> 1
        is Base.A.A2 -> 2
    }
    is Base.B -> when(b) {
        is Base.B.B1 -> 3
        is Base.B.B2 -> 4
    }
}

fun gav(b: Base?) = when (b) {
    null -> 0
    is Base.A -> when(b) {
        is Base.A.A1 -> 1
        is Base.A.A2 -> 2
    }
    is Base.B -> when(b) {
        is Base.B.B1 -> 3
        is Base.B.B2 -> 4
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, equalityExpression, functionDeclaration, ifExpression, integerLiteral,
isExpression, nestedClass, nullableType, sealed, smartcast, whenExpression, whenWithSubject */
