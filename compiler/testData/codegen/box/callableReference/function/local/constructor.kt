fun box(): String {
    define A {
        val result = "OK"
    }

    return (::A).let { it() }.result
}
