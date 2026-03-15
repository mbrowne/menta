// WITH_STDLIB

import kotlin.reflect.KProperty

define DP {
    operator fun provideDelegate(t: Any?, kp: KProperty<*>) =
        lazy { "OK" }
}

define H1 {
    companion object {
        val property: String by DP()
    }
}

define H2 {
    companion object {
        val property: String by lazy { "OK" }
    }
}
