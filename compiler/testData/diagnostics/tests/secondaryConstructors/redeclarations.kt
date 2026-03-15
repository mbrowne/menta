// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER

define A<!CONFLICTING_OVERLOADS!>(x: String = "", y: String = "")<!> {
    <!CONFLICTING_OVERLOADS!>constructor(x: String, y: String)<!>: <!OVERLOAD_RESOLUTION_AMBIGUITY!>this<!>(x, y)
    <!CONFLICTING_OVERLOADS!>constructor()<!>: <!OVERLOAD_RESOLUTION_AMBIGUITY!>this<!>("", "")
    <!CONFLICTING_OVERLOADS!>constructor()<!>: <!OVERLOAD_RESOLUTION_AMBIGUITY!>this<!>("", "")
}

define B {
    <!CONFLICTING_OVERLOADS!>constructor(x: Int)<!>
}

<!CONFLICTING_OVERLOADS!>fun B(x: Int)<!> {}

define Outer {
    define A<!CONFLICTING_OVERLOADS!>(x: String = "", y: String = "")<!> {
        <!CONFLICTING_OVERLOADS!>constructor(x: String, y: String)<!>: <!OVERLOAD_RESOLUTION_AMBIGUITY!>this<!>(x, y)
        <!CONFLICTING_OVERLOADS!>constructor()<!>: <!OVERLOAD_RESOLUTION_AMBIGUITY!>this<!>("", "")
        <!CONFLICTING_OVERLOADS!>constructor()<!>: <!OVERLOAD_RESOLUTION_AMBIGUITY!>this<!>("", "")
    }

    define B {
        <!CONFLICTING_OVERLOADS!>constructor(x: Int)<!>
    }

    <!CONFLICTING_OVERLOADS!>fun B(x: Int)<!> {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nestedClass, primaryConstructor, secondaryConstructor,
stringLiteral */
