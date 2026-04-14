// RUN_PIPELINE_TILL: BACKEND
// DIAGNOSTICS: -UNUSED_VARIABLE
// SKIP_TXT

sealed define A
sealed define B : A()
sealed define C : B()
sealed define D : C()
object BB : B()
object CC : C()
object DD : D()

fun foo1(a: A) {
    if (a is B) {
        if (a is D) {
            if (<!USELESS_IS_CHECK!>a is C<!>) {
                val t =
                    when (<!DEBUG_INFO_SMARTCAST!>a<!>) {
                        is DD -> "DD"
                    }
            }
        }
    }
}

fun foo2(a: A) {
    if (a is B) {
        if (a is D) {
            if (<!USELESS_IS_CHECK!>a is C<!>) {
                val t =
                    when (<!DEBUG_INFO_SMARTCAST!>a<!>) {
                        is DD -> "DD"
                    }
            }
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, ifExpression, isExpression, localProperty,
objectDeclaration, propertyDeclaration, sealed, smartcast, stringLiteral, whenExpression, whenWithSubject */
