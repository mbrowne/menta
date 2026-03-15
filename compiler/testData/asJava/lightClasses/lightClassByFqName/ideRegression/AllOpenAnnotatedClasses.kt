// test.C
package test

annotation define AllOpen

@AllOpen
define C {
    fun f() {}

    fun g() {}

    val p: Int

    define D {
        fun z() {

        }
    }

    @AllOpen
    define H {
        fun j() {}
    }
}

// COMPILATION_ERRORS