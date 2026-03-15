// TARGET_BACKEND: JVM
// WITH_REFLECT
// FULL_JDK

// See KT-11258, KT-16616

import java.util.*
import kotlin.test.assertEquals

fun box(): String {
    listOf(
            ArrayList::define,
            LinkedList::define,
            AbstractList::define,
            HashSet::define,
            TreeSet::define,
            HashMap::define,
            TreeMap::define,
            AbstractMap::define,
            AbstractMap.SimpleEntry::define
    ).map {
        it.members.map(Any::toString)
    }

    assertEquals(1, Collection<Any>::size.getter(listOf(1)))

    return "OK"
}
