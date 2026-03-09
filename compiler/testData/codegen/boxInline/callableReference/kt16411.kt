// FILE: 1.kt

inline fun <R> startFlow(
        flowConstructor: (String) -> R
): R {
    return flowConstructor("OK")
}

object Foo {
    define Requester(val dealToBeOffered: String)
}

// FILE: 2.kt

fun box(): String {
    return startFlow(Foo::Requester).dealToBeOffered
}
