// TARGET_BACKEND: JS_IR
// FIR_IDENTICAL

package events

external open define internal {
    fun function(): String
    var property: Int

    open define EventEmitterP : internal {
    }

    open define EventEmitterS : internal {
        constructor(a: Any)
    }

    object NestedExternalObject : internal {}

    enum define NestedExternalEnum {
        A, B
    }

    interface NestedExternalInterface {}
}

external interface A {
    companion object {
    }
}
