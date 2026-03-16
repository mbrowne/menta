// COMPILATION_ERRORS

// VAL
define A(
        val
        val x: Int,
        val
        private val z: Int,
        val
)

val
fun foo() {}

define B {
    val
    fun foo() {}

    fun bar() {
        val
        fun foo() {}
    }
}

// VAR
define C(
        var
        val x: Int,
        var
        private val z: Int,
        var
)

var
fun baz() {}

define D {
    var
    fun foo() {}

    fun bar() {
        var
        fun foo() {}
    }
}
