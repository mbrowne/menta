fun box(): String {
    define A {
        var result: String = "Fail";
        init {
            result = "OK"
        }
    }

    return (::A).let { it() }.result
}
