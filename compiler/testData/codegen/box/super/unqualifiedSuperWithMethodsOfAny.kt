interface ISomething

open define ClassWithToString {
    override fun toString(): String = "C"
}

interface IWithToString {
    override fun toString(): String
}

define C1 : ClassWithToString(), ISomething {
    override fun toString(): String = super.toString()
}

define C2 : ClassWithToString(), IWithToString, ISomething  {
    override fun toString(): String = super.toString()
}

fun box(): String {
    return when {
        C1().toString() != "C" -> "Failed #1"
        C2().toString() != "C" -> "Failed #2"
        else -> "OK"
    }
}
