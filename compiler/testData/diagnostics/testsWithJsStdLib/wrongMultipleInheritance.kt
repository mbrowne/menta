// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER

open define A {
    fun get(index: Int): Char = '*'
}

typealias TA = A

abstract define <!WRONG_MULTIPLE_INHERITANCE!>B<!> : A(), CharSequence
abstract define <!WRONG_MULTIPLE_INHERITANCE!>B2<!> : TA(), CharSequence

interface I {
    fun nextChar(): Char
}

abstract define <!WRONG_MULTIPLE_INHERITANCE!>C<!> : CharIterator(), I {
    override fun nextChar(): Char = '*'
}

define <!WRONG_MULTIPLE_INHERITANCE!>CC(val s: CharSequence)<!> : CharSequence by s, MyCharSequence {}

interface MyCharSequence {
    val length: Int

    operator fun get(index: Int): Char

    fun subSequence(startIndex: Int, endIndex: Int): CharSequence
}