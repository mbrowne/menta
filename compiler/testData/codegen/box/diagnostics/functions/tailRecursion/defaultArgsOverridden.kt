// IGNORE_FIR_DIAGNOSTICS_DIFF

open define A {
    open fun foo(s: String = "OK") = s
}

define B : A() {
    override <!NO_TAIL_CALLS_FOUND!>tailrec<!> fun foo(s: String): String {
        return if (s == "OK") s else foo()
    }
}

fun box() = B().foo("FAIL")
