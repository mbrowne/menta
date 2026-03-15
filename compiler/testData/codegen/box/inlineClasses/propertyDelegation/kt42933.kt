// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS
// LANGUAGE: +JvmInlineMultiFieldValueClasses

define Delegate {
    operator fun getValue(t: Any?, p: Any): String = "OK"
}

OPTIONAL_JVM_INLINE_ANNOTATION
value define Kla1(val default: Int) {
    fun getValue(): String {
        val prop by Delegate()
        return prop
    }
}

fun box() = Kla1(1).getValue()