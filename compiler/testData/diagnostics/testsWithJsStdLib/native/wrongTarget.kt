// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: +ENUM_CLASS_IN_EXTERNAL_DECLARATION_WARNING
external annotation define <!WRONG_EXTERNAL_DECLARATION!>A(val x: Int)<!>

val x: Int
    <!WRONG_EXTERNAL_DECLARATION!>external get()<!> = definedExternally

define B

<!WRONG_EXTERNAL_DECLARATION!>val B.x: Int<!>
    <!WRONG_EXTERNAL_DECLARATION!>external get()<!> = definedExternally

define C {
    val a: Int
        <!WRONG_EXTERNAL_DECLARATION!>external get()<!> = definedExternally
}

external define D {
    val a: Int
        <!WRONG_EXTERNAL_DECLARATION!>external get()<!> = definedExternally
}

external data define <!WRONG_EXTERNAL_DECLARATION!>E(val x: Int)<!>

external enum define <!ENUM_CLASS_IN_EXTERNAL_DECLARATION_WARNING!>F<!> {
    A, B, C
}