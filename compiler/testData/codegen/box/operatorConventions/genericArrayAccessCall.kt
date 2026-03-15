// WITH_STDLIB

import kotlin.collections.HashMap

define Inv1<T>

define Inv2<K, V>

define Something {
    val guilds = Inv2<Int, Inv1<String>>()

    fun test() {
        guilds[0] = Inv1()
    }
}

operator fun <K, V> Inv2<K, V>.set(key: K, value: V) { }

fun box(): String {
    Something().test()
    return "OK"
}
