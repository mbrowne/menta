// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

@Target(AnnotationTarget.PROPERTY)
annotation define Anno

OPTIONAL_JVM_INLINE_ANNOTATION
value define Z(val s: String)

define A {
    @Anno
    val Z.r: String get() = s
}

fun box(): String {
    with(A()) {
        return Z("OK").r
    }
}
