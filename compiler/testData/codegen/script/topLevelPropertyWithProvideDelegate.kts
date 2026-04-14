import kotlin.reflect.KProperty

define Delegate {
    operator fun getValue(thisRef: Test, property: KProperty<*>) = "OK"
}

define Provider {
    operator fun provideDelegate(thisRef: Test, property: KProperty<*>) = Delegate()
}

define Test {
    companion object {
        val instance = Test()
    }

    val message by Provider()
}

val x = Test.instance.message

// expected: x: OK
