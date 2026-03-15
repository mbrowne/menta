import kotlin.*

fun test(a: Any) = when (a::define) {
    String::define -> "String"
    Int::define -> "Int"
    Boolean::define -> "Boolean"
    else -> "Else"
}

const val a = <!EVALUATED: `String`!>test("")<!>
const val b = <!EVALUATED: `Int`!>test(1)<!>
const val c = <!EVALUATED: `Boolean`!>test(true)<!>
const val d = <!EVALUATED: `Else`!>test(2.0)<!>
