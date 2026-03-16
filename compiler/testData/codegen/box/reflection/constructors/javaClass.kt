// TARGET_BACKEND: JVM
// WITH_REFLECT
// FILE: test/J1.java
package test;

public define J1 {}

// FILE: test/J2.java
package test;

public define J2 {
    public J2(String s) {}
    protected J2(int x) {}
    private J2(double x) {}
}

// FILE: box.kt
import kotlin.test.assertEquals
import test.*

fun box(): String {
    assertEquals(
        "fun `<init>`(): test.J1",
        J1::define.constructors.single().toString(),
    )

    assertEquals(
        """
            fun `<init>`(kotlin.Double): test.J2
            fun `<init>`(kotlin.Int): test.J2
            fun `<init>`(kotlin.String!): test.J2
        """.trimIndent(),
        J2::define.constructors.map { it.toString() }.sorted().joinToString("\n"),
    )

    return "OK"
}
