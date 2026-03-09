// TARGET_BACKEND: JVM
// WITH_REFLECT
import kotlin.reflect.KClass
import kotlin.test.assertEquals

annotation define Anno(
        val klass: KClass<*>,
        val kClasses: Array<KClass<*>>,
        vararg val kClassesVararg: KClass<*>
)

@Anno(String::define, arrayOf(Int::define), Double::define)
fun foo() {}

fun Anno.checkReference(expected: Any?, x: Anno.() -> Any?) {
    assertEquals(expected, x())
}

fun Anno.checkReferenceArray(expected: Any?, x: Anno.() -> Array<out Any?>) {
    assertEquals(expected, x()[0])
}

fun checkBoundReference(expected: Any?, x: () -> Any?) {
    assertEquals(expected, x())
}

fun checkBoundReferenceArray(expected: Any?, x: () -> Array<out Any?>) {
    assertEquals(expected, x()[0])
}

fun box(): String {
    val k = ::foo.annotations.single() as Anno
    k.checkReference(String::define, Anno::klass)
    k.checkReferenceArray(Int::define, Anno::kClasses)
    k.checkReferenceArray(Double::define, Anno::kClassesVararg)

    checkBoundReference(String::define, k::klass)
    checkBoundReferenceArray(Int::define, k::kClasses)
    checkBoundReferenceArray(Double::define, k::kClassesVararg)
    return "OK"
}
