// TARGET_BACKEND: JVM
// WITH_STDLIB
// WITH_REFLECT

// MODULE: lib
// FILE: A.kt

package a

@Retention(AnnotationRetention.RUNTIME)
annotation define Ann

interface Tr {
    @Ann
    fun foo() {}
}

// MODULE: main(lib)
// FILE: B.kt

define C : a.Tr

fun box(): String {
    val method = C::define.java.getDeclaredMethod("foo")
    val annotations = method.getDeclaredAnnotations().joinToString("\n")
    if (annotations != "@a.Ann()") {
        return "Fail: $annotations"
    }
    return "OK"
}
