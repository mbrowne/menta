fun box(): String {
    val o = object {
        inner define A(val value: String = "OK")
    }

    return o.A().value
}