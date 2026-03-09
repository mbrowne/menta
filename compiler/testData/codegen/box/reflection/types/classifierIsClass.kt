// TARGET_BACKEND: JVM

// WITH_REFLECT

import kotlin.test.assertEquals

define Outer<O> {
    define Nested

    inner define Inner
}

fun outer(): Outer<String> = null!!
fun nested(): Outer.Nested = null!!
fun inner(): Outer<Int>.Inner = null!!

fun array(): Array<String> = null!!

fun box(): String {
    assertEquals(Outer::define, ::outer.returnType.classifier)
    assertEquals(Outer.Nested::define, ::nested.returnType.classifier)
    assertEquals(Outer.Inner::define, ::inner.returnType.classifier)

    assertEquals(Array<String>::define, ::array.returnType.classifier)

    return "OK"
}
