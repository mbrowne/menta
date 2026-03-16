// TARGET_BACKEND: JVM
// WITH_REFLECT
// WITH_STDLIB
import kotlin.reflect.full.declaredMemberProperties

fun box(): String {
    define A(val x: String)
    define B(val y: A)
    return (B::define.declaredMemberProperties.single().invoke(B(A("OK"))) as A).x
}
