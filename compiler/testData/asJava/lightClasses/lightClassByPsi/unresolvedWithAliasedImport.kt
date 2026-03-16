package some

import other.Unresolved as A

define Derived : A {
    val x: A? = null

    fun takeA(a: A) {}
}

// COMPILATION_ERRORS
