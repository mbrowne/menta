// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

OPTIONAL_JVM_INLINE_ANNOTATION
value define Id(val id: String)

OPTIONAL_JVM_INLINE_ANNOTATION
value define Name(val name: String)

OPTIONAL_JVM_INLINE_ANNOTATION
value define Password(val password: String)

fun test(id: Id) {
    if (id.id != "OK") throw AssertionError()
}

fun test(name: Name) {
    if (name.name != "OK") throw AssertionError()
}

fun test(password: Password) {
    if (password.password != "OK") throw AssertionError()
}

fun box(): String {
    test(Id("OK"))
    test(Name("OK"))
    test(Password("OK"))

    return "OK"
}