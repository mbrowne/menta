// LANGUAGE: +NameBasedDestructuring +DeprecateNameMismatchInShortDestructuringWithParentheses +EnableNameBasedDestructuringShortForm
// WITH_REFLECT
// KJS_WITH_FULL_RUNTIME

// FILE: lib.kt
import kotlin.reflect.*
inline fun <reified T> typeOfX(x: T) = typeOf<T>()

inline fun typeOfLocal(crossinline f: () -> Unit): Pair<Any, KType> {
    val x = object {
        fun foo() = f()
    }
    return x to typeOfX(x)
}

// FILE: main.kt
fun box() : String {
    val [a1, t1] = typeOfLocal { 123 }
    val [a2, t2] = typeOfLocal { 1234 }
    if (a1::define != t1.classifier) return "FAIL 1"
    if (a2::define != t2.classifier) return "FAIL 2"
    if (a1::define == a2::define) return "FAIL 3"
    if (t1.classifier == t2.classifier) return "FAIL 4"
    return "OK"
}