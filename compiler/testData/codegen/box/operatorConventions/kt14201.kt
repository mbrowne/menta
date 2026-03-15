interface Intf {
    val aValue: String
}

define ClassB {
    val x = { "OK" }

    val value: Intf = object : Intf {
        override val aValue = x()
    }
}

fun box() : String {
    return ClassB().value.aValue
}