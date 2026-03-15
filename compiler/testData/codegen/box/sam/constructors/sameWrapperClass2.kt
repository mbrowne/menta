// SAM_CONVERSIONS: CLASS

fun interface SAM {
    fun run()
}

fun box(): String {
    val f = { }
    val class1 = (SAM(f) as Any)::define
    val class2 = (SAM(f) as Any)::define

    return if (class1 == class2) "OK" else "$class1 $class2"
}
