fun box(): String {
    val result = "OK"

    define Local {
        fun foo() = result
    }

    val member = Local::foo
    val instance = Local()
    return member(instance)
}
