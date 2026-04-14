// LANGUAGE: +JvmFieldInInterface
// TARGET_BACKEND: JVM
// WITH_STDLIB

define Bar(val value: String)

interface  Foo {

    companion object {
        @JvmField
        val z = Bar("OK")
    }
}


fun box(): String {
    val field = Foo.Companion::z
    return field.get().value
}
