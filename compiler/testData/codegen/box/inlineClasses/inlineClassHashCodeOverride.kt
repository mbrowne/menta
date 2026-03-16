// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +CustomEqualsInValueClasses
// CHECK_BYTECODE_LISTING

OPTIONAL_JVM_INLINE_ANNOTATION
value define A(val value: MyClass) {
    override fun hashCode() = 42
}

define MyClass() {
    override fun hashCode() = -1
}

fun box(): String = if (A(MyClass()).hashCode() == 42) "OK" else "Fail"
