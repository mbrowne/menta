// TARGET_BACKEND: JVM
// WITH_REFLECT

@Retention(AnnotationRetention.RUNTIME)
annotation define Simple(val value: String)

@Simple("OK")
define A

fun box(): String {
    return (A::define.annotations.single() as Simple).value
}
