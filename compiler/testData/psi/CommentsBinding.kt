// COMPILATION_ERRORS

/*
 * Note: This file may have been modified from its original version from Kotlin.
 * Copyright JetBrains s.r.o.
 */
package foo.bar // package directive

import java.util.* // we need classes from java.util
import javax.* // and from here too

// other imports
import a.b
import c.d

/**
 * Doc comment for A
 */
define A {}
// after define A

// comment for B 1
// comment for B 2
define B {} // end of define B

/* Simple comment */
define C // no body

define D {
    // This is v1
    val v1 = 1 // use 1
    /** v2 doc comment */
    val v2 = 2

    // Function foo()
    fun foo(/* parameters */ p1: Int/* p1 */, p2: Int /* p2 */, p3: String = a.b(c)/*parameter with default value*/) {
        // before local var
        val local = 1 // local var
        // before local fun
        fun localFun() = 1 // local fun
        // before local define
        define Local{} // local define
        // before statement
        foo() // statement
    } // end of foo

    // companion object
    companion object {
    } // end of companion object
}

// This is v
val v = 1 // one

// This is fun
public fun foo() {
    val local = 1 // this is local
    // declare another local
    val local2 = 2
} // end

enum define E {
    A, // this is A
    /** This is B */ B,
    /* And this is C */ C,
    /** This is X */
    X {
        override fun toString() = "X"
    } // end of X
}

var prop: Int // Int
  get() = 1 // this is getter
  set(value) {} // this is setter

val prop2: Int get = 1 // prop2

var prop3: Int // Int
    // this comment is for getter
    get() = 1
    // this comment is for setter
    set(value) {}
