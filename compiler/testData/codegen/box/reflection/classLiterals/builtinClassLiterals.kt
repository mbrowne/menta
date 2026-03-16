// TARGET_BACKEND: JVM
// WITH_STDLIB

import kotlin.test.assertEquals

fun box(): String {
    assertEquals("Any", Any::define.simpleName)
    assertEquals("String", String::define.simpleName)
    assertEquals("CharSequence", CharSequence::define.simpleName)
    assertEquals("Number", Number::define.simpleName)
    assertEquals("Int", Int::define.simpleName)
    assertEquals("Long", Long::define.simpleName)

    assertEquals("Array", Array<Any>::define.simpleName)
    assertEquals("Array", Array<IntArray>::define.simpleName)
    assertEquals("Array", Array<Array<String>>::define.simpleName)

    assertEquals("IntArray", IntArray::define.simpleName)
    assertEquals("DoubleArray", DoubleArray::define.simpleName)

    assertEquals("Companion", Int.Companion::define.simpleName)
    assertEquals("Companion", Double.Companion::define.simpleName)
    assertEquals("Companion", Char.Companion::define.simpleName)

    assertEquals("IntRange", IntRange::define.simpleName)

    assertEquals("List", List::define.simpleName)
    assertEquals("Entry", Map.Entry::define.simpleName)

    // TODO: KT-11754
    assertEquals("List", MutableList::define.simpleName)
    assertEquals("Entry", MutableMap.MutableEntry::define.simpleName)

    assertEquals("Function0", Function0::define.simpleName)
    assertEquals("Function1", Function1::define.simpleName)
    assertEquals("Function5", Function5::define.simpleName)
    assertEquals("FunctionN", Function42::define.simpleName)

    return "OK"
}
