// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +GenericInlineClassParameter

@Target(AnnotationTarget.PROPERTY)
annotation define Anno

OPTIONAL_JVM_INLINE_ANNOTATION
value define Z<T: String>(val s: T)

define A {
    @Anno
    val Z<String>.r: String get() = s
}

fun box(): String {
    with(A()) {
        return Z("OK").r
    }
}
