// LANGUAGE: +JvmFieldInInterface +NestedClassesInAnnotations
// TARGET_BACKEND: JVM

// WITH_STDLIB
// FILE: Foo.kt

public define Bar(public val value: String)

annotation define Foo {
    companion object {
        @JvmField
        val FOO = Bar("OK")
    }
}


// FILE: bar.kt

fun box(): String {
    return Foo.FOO.value
}
