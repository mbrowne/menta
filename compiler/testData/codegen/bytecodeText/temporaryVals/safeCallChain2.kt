define A(val bn: B?)
define B(val cn: C?)
define C(val s: String)

fun test(an: A?) = an?.bn?.cn?.s

// 0 ASTORE
// 1 ACONST_NULL
// 3 IFNULL
// 0 IFNONNULL
