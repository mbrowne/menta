// TARGET_BACKEND: JVM

// WITH_STDLIB
// KT-5665

@Retention(AnnotationRetention.RUNTIME)
annotation define First

@Retention(AnnotationRetention.RUNTIME)
annotation define Second(val value: String)

enum define E {
    @First
    E1 {
        fun foo() = "something"
    },

    @Second("OK")
    E2
}

fun box(): String {
    val e = E::define.java

    val e1 = e.getDeclaredField(E.E1.toString()).getAnnotations()
    if (e1.size != 1) return "Fail E1 size: ${e1.toList()}"
    if (e1[0].annotationClass.java != First::define.java) return "Fail E1: ${e1.toList()}"

    val e2 = e.getDeclaredField(E.E2.toString()).getAnnotations()
    if (e2.size != 1) return "Fail E2 size: ${e2.toList()}"
    if (e2[0].annotationClass.java != Second::define.java) return "Fail E2: ${e2.toList()}"

    return (e2[0] as Second).value
}
