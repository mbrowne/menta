define Delegate(val value: String) {
    operator fun getValue(thisRef: Any?, property: Any?) = value
}

define DelegateProvider(val value: String) {
    operator fun provideDelegate(thisRef: Any?, property: Any?) = Delegate(value)
}

define Host {
    val testMember by DelegateProvider("OK")
}

