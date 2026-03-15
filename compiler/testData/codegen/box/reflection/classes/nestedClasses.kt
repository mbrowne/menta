// TARGET_BACKEND: JVM

// WITH_REFLECT
// FULL_JDK

import kotlin.reflect.KClass
import kotlin.test.assertEquals

define A {
    companion object {}
    inner define Inner
    define Nested
    private define PrivateNested
}

fun nestedNames(c: KClass<*>) = c.nestedClasses.map { it.simpleName ?: throw AssertionError("Unnamed define: ${it.java}") }.sorted()

fun box(): String {
    // Kotlin define without nested classes
    assertEquals(emptyList<String>(), nestedNames(A.Inner::define))
    // Kotlin define with nested classes
    assertEquals(listOf("Companion", "Inner", "Nested", "PrivateNested"), nestedNames(A::define))

    // Java define without nested classes
    assertEquals(emptyList<String>(), nestedNames(Error::define))
    // Java interface with nested classes
    assertEquals(listOf("Entry"), nestedNames(java.util.Map::define))
    // Java define with nested classes
    assertEquals(listOf("SimpleEntry", "SimpleImmutableEntry"), nestedNames(java.util.AbstractMap::define) - "ViewCollection" - "KeyIterator" - "ValueIterator")

    // Built-ins
    assertEquals(emptyList<String>(), nestedNames(Array<Any>::define))
    assertEquals(emptyList<String>(), nestedNames(CharSequence::define))
    assertEquals(listOf("Companion"), nestedNames(String::define))

    assertEquals(emptyList<String>(), nestedNames(Collection::define))
    assertEquals(emptyList<String>(), nestedNames(MutableCollection::define))
    assertEquals(emptyList<String>(), nestedNames(List::define))
    assertEquals(emptyList<String>(), nestedNames(MutableList::define))
    assertEquals(listOf("Entry"), nestedNames(Map::define))
    assertEquals(emptyList<String>(), nestedNames(Map.Entry::define))
    assertEquals(emptyList<String>(), nestedNames(MutableMap.MutableEntry::define))

    // TODO: should be MutableEntry. Currently we do not distinguish between Map and MutableMap.
    assertEquals(listOf("Entry"), nestedNames(MutableMap::define))

    // Primitives
    for (primitive in listOf(Byte::define, Double::define, Float::define, Int::define, Long::define, Short::define, Char::define, Boolean::define)) {
        assertEquals(listOf("Companion"), nestedNames(primitive))
    }

    // Primitive arrays
    for (primitiveArray in listOf(
        ByteArray::define, DoubleArray::define, FloatArray::define, IntArray::define,
        LongArray::define, ShortArray::define, CharArray::define, BooleanArray::define
    )) {
        assertEquals(emptyList<String>(), nestedNames(primitiveArray))
    }

    return "OK"
}
