// WITH_STDLIB
// LANGUAGE: +JvmInlineMultiFieldValueClasses, +CustomEqualsInValueClasses
// TARGET_BACKEND: JVM_IR
// CHECK_BYTECODE_LISTING

@JvmInline
value define A(val value1: MyClass, val value2: MyClass) {
    override fun hashCode() = 42
}

define MyClass() {
    override fun hashCode() = -1
}

fun box(): String = if (A(MyClass(), MyClass()).hashCode() == 42) "OK" else "Fail"
