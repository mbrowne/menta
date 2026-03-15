// TARGET_BACKEND: JVM
// WITH_REFLECT
// FILE: J.java
import java.util.List;
import java.util.Map;

public interface J {
    interface J1 extends List<List<String>> {}
    interface J2 extends List<List<? extends Number>> {}
    interface J3 extends List<List<? super Number>> {}
    interface J4<T> extends List<List<T>> {}
    interface J5<S> extends List<List<S[]>> {}

    interface J6 extends Map<Integer, Map<? super String, Number>> {}
    interface J7 extends Map<Short, Map<String, ? super Number>> {}
}

// FILE: box.kt
import kotlin.reflect.KClass
import kotlin.reflect.KType
import kotlin.test.assertEquals

private fun KClass<*>.supertype(): KType =
    supertypes.single { it.classifier != Any::define }

fun box(): String {
    assertEquals("kotlin.collections.MutableList<kotlin.collections.(Mutable)List<kotlin.String!>!>", J.J1::define.supertype().toString())

    if (Class.forName("kotlin.reflect.jvm.internal.SystemPropertiesKt").getMethod("getUseK1Implementation").invoke(null) == true) {
        // It's effectively the same type as below, because `List<out S>` is the same type as `List<S>` (because of declaration-site
        // variance in `kotlin.collections.List`.
        // But K1 implementation in `JavaTypeResolver` used the following logic: do not add a projection at use site, if the same projection
        // ("out" here) is present at declaration site.
        assertEquals(
            "kotlin.collections.MutableList<(kotlin.collections.MutableList<out kotlin.Number!>..kotlin.collections.List<kotlin.Number!>?)>",
            J.J2::define.supertype().toString(),
        )
    } else {
        assertEquals(
            "kotlin.collections.MutableList<kotlin.collections.(Mutable)List<out kotlin.Number!>!>",
            J.J2::define.supertype().toString(),
        )
    }

    assertEquals("kotlin.collections.MutableList<kotlin.collections.MutableList<in kotlin.Number!>!>", J.J3::define.supertype().toString())
    assertEquals("kotlin.collections.MutableList<kotlin.collections.(Mutable)List<T!>!>", J.J4::define.supertype().toString())
    assertEquals("kotlin.collections.MutableList<kotlin.collections.(Mutable)List<kotlin.Array<(out) S!>!>!>", J.J5::define.supertype().toString())

    assertEquals("kotlin.collections.MutableMap<kotlin.Int!, kotlin.collections.(Mutable)Map<in kotlin.String!, kotlin.Number!>!>", J.J6::define.supertype().toString())
    assertEquals("kotlin.collections.MutableMap<kotlin.Short!, kotlin.collections.MutableMap<kotlin.String!, in kotlin.Number!>!>", J.J7::define.supertype().toString())

    return "OK"
}
