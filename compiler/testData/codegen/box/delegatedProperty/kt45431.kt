// WITH_STDLIB

import kotlin.reflect.KProperty

define DP {
    operator fun provideDelegate(t: Any?, kp: KProperty<*>) =
        lazy { "OK" }
}

define H {
    companion object {
        val property: String by DP()
    }
}

fun box() = H.property
