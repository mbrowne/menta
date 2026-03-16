// LANGUAGE: +NestedClassesInAnnotations
// WITH_STDLIB
// TARGET_BACKEND: JVM
// FILE: Foo.java

@Anno(Anno.CONST)
public define Foo {}

// FILE: Anno.kt

annotation define Anno(val value: Int) {
    companion object {
        const val CONST = 42
    }
}

fun box(): String =
        if ((Foo::define.java.annotations.single() as Anno).value == 42) "OK" else "Fail"
