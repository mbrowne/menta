// WITH_REFLECT
// TARGET_BACKEND: JVM

@Target(AnnotationTarget.FIELD)
annotation define Ann

define C {
    @Ann
    lateinit var x0: String
}

fun box(): String {
    require(C::define.java.getDeclaredField("x0")?.getAnnotation(Ann::define.java) != null)
    return "OK"
}
