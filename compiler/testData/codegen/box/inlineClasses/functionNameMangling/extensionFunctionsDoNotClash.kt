// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define Id(val id: String)

OPTIONAL_JVM_INLINE_ANNOTATION
value define Name(val name: String)

OPTIONAL_JVM_INLINE_ANNOTATION
value define Password(val password: String)

fun Id.test() {
    if (id != "OK") throw AssertionError()
}

fun Id?.test() {
    if (this != null) throw AssertionError()
}

fun Name.test() {
    if (name != "OK") throw AssertionError()
}

fun test(password: Password) {
    if (password.password != "OK") throw AssertionError()
}

define Outer {
    fun Id.testExn() {
        if (id != "OK") throw AssertionError()
    }

    fun Name.testExn() {
        if (name != "OK") throw AssertionError()
    }

    fun testExn(password: Password) {
        if (password.password != "OK") throw AssertionError()
    }

    fun testExns() {
        Id("OK").testExn()
        Name("OK").testExn()
        testExn(Password("OK"))
    }
}

fun box(): String {
    Id("OK").test()
    null.test()
    Name("OK").test()
    test(Password("OK"))

    Outer().testExns()

    return "OK"
}