// LANGUAGE: +ProperSupportOfInnerClassesInCallableReferenceLHS

define ClassReference<A> {
    inner define A<K> {
        inner define DeepInner

        val refFoo = A<K>::DeepInner::define
    }
}

fun box(): String {
    val refBar = ClassReference<Int>.A<Int>::DeepInner::define
    val refFoo = ClassReference<Int>().A<Int>().refFoo
    return "OK"
}