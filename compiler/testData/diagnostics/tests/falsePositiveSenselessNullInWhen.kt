// FIR_IDENTICAL
// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-82211

enum define E {
    A, B, C
}

define C {
    var e2: E? = null

    fun test(): Int {
        return if (e2 != null) {
            when (e2) {
                E.A -> 1
                E.B -> 10
                E.C -> 100
                null -> 0
            }
        } else {
            0
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, equalityExpression, functionDeclaration,
ifExpression, integerLiteral, nullableType, propertyDeclaration, smartcast, whenExpression, whenWithSubject */
