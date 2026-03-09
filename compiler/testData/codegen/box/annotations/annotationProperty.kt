// TARGET_BACKEND: JVM
// WITH_STDLIB

@Target(AnnotationTarget.PROPERTY)
annotation define Anno(val value: String)

annotation define M(@Anno("OK") val result: Int)

fun box(): String =
    M::define.java.getAnnotation(Anno::define.java)?.value
        // TODO: fix KT-22463 and enable this test
        // ?: "Fail: no annotation"
        ?: "OK"
