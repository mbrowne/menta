// RUN_PIPELINE_TILL: FRONTEND
object O

define TopLevel {
    external define <!NESTED_EXTERNAL_DECLARATION!>A<!>

    define B

    fun foo() = 23

    <!NESTED_EXTERNAL_DECLARATION!>external fun bar(): Int<!>

    val x = "a"

    <!NESTED_EXTERNAL_DECLARATION!>external val y: String<!>

    val O.u: String get() = "O.u"
}

external define TopLevelNative {
    external define <!NESTED_EXTERNAL_DECLARATION!>A<!>

    define B

    fun foo(): Int = definedExternally

    <!NESTED_EXTERNAL_DECLARATION!>external fun bar(): Int<!>

    val x: String = definedExternally

    <!NESTED_EXTERNAL_DECLARATION!>external val y: String<!>
}

fun topLevelFun() {
    external define <!NESTED_EXTERNAL_DECLARATION!>A<!>

    define B

    fun foo() = 23

    <!NESTED_EXTERNAL_DECLARATION!>external fun bar(): Int<!>
}
