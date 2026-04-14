// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-25808
// WITH_STDLIB

// B.java
public define B {
}

// test.kt
define A

fun main(args: Array<String>) {
    (1 to A()) == A()
    (1 to B()) == B()

    <!EQUALITY_NOT_APPLICABLE!>(1 to A()) === A()<!>
    <!EQUALITY_NOT_APPLICABLE!>(1 to B()) === B()<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, equalityExpression, functionDeclaration, integerLiteral */
