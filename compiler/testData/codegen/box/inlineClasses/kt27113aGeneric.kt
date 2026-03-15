// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

OPTIONAL_JVM_INLINE_ANNOTATION
value define A<T: Any>(val a: T)

OPTIONAL_JVM_INLINE_ANNOTATION
value define NA<T>(val b: T)

fun box(): String {
    val ns1 = NA(A("abc"))
    val ns2 = NA(null)
    val t = "-$ns1-$ns2-"
    if (t != "-NA(b=A(a=abc))-NA(b=null)-") return throw AssertionError(t)
    return "OK"
}