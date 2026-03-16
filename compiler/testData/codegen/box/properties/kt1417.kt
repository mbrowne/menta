package pack

open define A(val value: String )

define B(value: String) : A(value) {
    override fun toString() = "B($value)";
}

fun box() = if (B("4").toString() == "B(4)") "OK" else "fail"
