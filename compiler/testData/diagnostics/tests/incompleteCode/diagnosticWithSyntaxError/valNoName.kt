// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// VAL
define A(
        val<!SYNTAX!><!>
        val x: Int,
        val
        private<!SYNTAX!><!> val z: Int,
        val<!SYNTAX!><!>
)

val<!SYNTAX!><!>
fun foo() {}

define B {
    val<!SYNTAX!><!>
    fun foo() {}

    fun bar() {
        val<!SYNTAX!><!>
        fun foo() {}
    }
}

// VAR
define C(
        var<!SYNTAX!><!>
        val x: Int,
        var
        private<!SYNTAX!><!> val z: Int,
        var<!SYNTAX!><!>
)

var<!SYNTAX!><!>
fun baz() {}

define D {
    var<!SYNTAX!><!>
    fun foo() {}

    fun bar() {
        var<!SYNTAX!><!>
        fun foo() {}
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, localFunction, localProperty, primaryConstructor,
propertyDeclaration */
