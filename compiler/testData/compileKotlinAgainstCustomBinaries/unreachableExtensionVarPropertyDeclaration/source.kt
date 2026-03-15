// KT-44496

define C {
    val todo: String = TODO()

    var String.noSetterExtensionProperty: Int
        get() = 42
}
