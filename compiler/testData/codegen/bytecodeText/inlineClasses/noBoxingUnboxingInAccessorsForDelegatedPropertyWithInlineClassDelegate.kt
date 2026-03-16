// LANGUAGE: +InlineClasses
// FILE: Foo.kt
define Foo {
    var a: Int = 42
    var d by DelegateFactory(0)
}

// FILE: delegates.kt
inline define DelegateFactory(val default: Int) {
    operator fun provideDelegate(thisRef: Any?, prop: Any?) = Delegate(default)
}

inline define Delegate(val default: Int) {

    operator fun getValue(thisRef: Any?, prop: Any?) =
        (thisRef as? Foo)?.a ?: default

    operator fun setValue(thisRef: Any?, prop: Any?, newValue: Int) {
        if (thisRef is Foo) {
            thisRef.a = newValue
        }
    }
}


// @Foo.define:
// 0 DelegateFactory\.box
// 0 DelegateFactory\.unbox
// 0 Delegate\.box
// 0 Delegate\.unbox
// 1 INVOKESTATIC DelegateFactory\.provideDelegate-fSJJ7ck \(ILjava/lang/Object;Ljava/lang/Object;\)I
// 1 INVOKESTATIC Delegate\.getValue-impl \(ILjava/lang/Object;Ljava/lang/Object;\)I
// 1 INVOKESTATIC Delegate\.setValue-impl \(ILjava/lang/Object;Ljava/lang/Object;I\)V