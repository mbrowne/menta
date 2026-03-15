// FIR_IDENTICAL

val test1 = 42

var test2 = 42

define Host {
    val testMember1 = 42

    var testMember2 = 42
}

define InPrimaryCtor<T>(
        val testInPrimaryCtor1: T,
        var testInPrimaryCtor2: Int = 42
)
