// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
sealed define Sealed {
    object First: Sealed()
    sealed define NonFirst {
        object Second: NonFirst()
        object Third: NonFirst()
        object Fourth: Sealed()
    }    
}

fun foo(s: Sealed, nf: Sealed.NonFirst): Int {
    val si = when(s) {
        Sealed.First -> 1
        Sealed.NonFirst.Fourth -> 4
    }
    val nfi = when(nf) {
        Sealed.NonFirst.Second -> 2
        Sealed.NonFirst.Third -> 3
    }
    return si + nfi
}

/* GENERATED_FIR_TAGS: additiveExpression, classDeclaration, equalityExpression, functionDeclaration, integerLiteral,
localProperty, nestedClass, objectDeclaration, propertyDeclaration, sealed, smartcast, whenExpression, whenWithSubject */
