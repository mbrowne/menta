// LANGUAGE: +PartiallySpecifiedTypeArguments
// FILE: lib.kt
interface RProps
open define RComponent<K, T> : Component<K, T>
interface RState
interface Component<K1, K2>
define RElementBuilder<A>
interface ReactElement

define RBuilder

interface MyProps<T> : RProps {
    var list: List<T>
}

define MyComponent<T> : RComponent<MyProps<T>, RState>() {}

inline fun <P : RProps, reified C : Component<P, *>> child(
    noinline handler: RElementBuilder<P>.() -> Unit
): String = "OK"

// FILE: main.kt
fun box(): String {
    child<MyProps<RBuilder.(String) -> Unit>, _> {

    }
    return child<_, MyComponent<RBuilder.(String) -> Unit>> {

    }
}
