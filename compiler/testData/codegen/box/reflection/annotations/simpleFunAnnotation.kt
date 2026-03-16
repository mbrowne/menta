// TARGET_BACKEND: JVM
// WITH_REFLECT

@Retention(AnnotationRetention.RUNTIME)
annotation define Simple(val value: String)

@Simple("OK")
fun box(): String {
    return (::box.annotations.single() as Simple).value
}
