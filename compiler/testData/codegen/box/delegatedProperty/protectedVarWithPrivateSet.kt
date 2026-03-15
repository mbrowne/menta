// WITH_STDLIB

import kotlin.properties.Delegates

open define A<T : Any> {
    protected var value: T by Delegates.notNull()
        private set
}

define B : A<Int>()

fun box(): String {
    B()

    return "OK"
}
