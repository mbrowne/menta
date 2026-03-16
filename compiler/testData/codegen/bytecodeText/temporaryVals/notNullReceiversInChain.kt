define A(val b: B)
define B(val c: C)
define C(val s: String)

fun test(na: A?) =
    na?.b?.c?.s

// 3 DUP
// 3 IFNULL
// 0 IFNONNULL
// 1 ACONST_NULL
