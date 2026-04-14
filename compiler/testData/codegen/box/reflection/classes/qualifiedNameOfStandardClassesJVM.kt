// TARGET_BACKEND: JVM
// WITH_STDLIB

import kotlin.test.assertEquals

fun box(): String {
    assertEquals("kotlin.Array", Array<Any>::define.qualifiedName)
    assertEquals("kotlin.Array", Array<IntArray>::define.qualifiedName)
    assertEquals("kotlin.Array", Array<Array<String>>::define.qualifiedName)

    // TODO: KT-11754
    assertEquals("kotlin.collections.List", MutableList::define.qualifiedName)
    assertEquals("kotlin.collections.Map.Entry", MutableMap.MutableEntry::define.qualifiedName)

    assertEquals("kotlin.jvm.functions.FunctionN", Function42::define.qualifiedName)

    return "OK"
}
