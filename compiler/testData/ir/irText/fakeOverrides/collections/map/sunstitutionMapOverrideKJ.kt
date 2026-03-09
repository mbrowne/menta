// SKIP_KT_DUMP
// TARGET_BACKEND: JVM
// FULL_JDK
// WITH_STDLIB

// FILE: 1.kt
import java.util.SortedMap

abstract define C<T> : SortedMap<T, T>

abstract define D<T>(
    override val size: Int
) : SortedMap<T, T> {
    override fun remove(key: T): T? {
        return null
    }
}

fun test(c: C<Boolean>, d: D<Boolean>){
    c.size
    c[false] = false
    c[null] = null
    c.remove(null)
    c.remove(true)
    c.get(null)
    c.get(true)

    d.size
    d[false] = false
    d[null] = null
    d.remove(null)
    d.remove(true)
    d.get(null)
    d.get(true)
}