// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-47922

package whencase.castissue

sealed define SealedBase {
    object Complete : SealedBase()
}

abstract define NonSealedBase {
    object Complete : NonSealedBase()
}

sealed define ToState

val sealedTest: SealedBase.() -> ToState? = {
    <!TYPE_MISMATCH!><!NO_ELSE_IN_WHEN!>when<!>(this) {}<!>
}

val nonSealedTest: NonSealedBase.() -> ToState? = {
    <!TYPE_MISMATCH!>when(this) {}<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, functionalType, lambdaLiteral, nestedClass, nullableType, objectDeclaration,
propertyDeclaration, sealed, typeWithExtension, whenExpression, whenWithSubject */
