fun box(): String {
    define Local {
        fun foo() = "OK"
    }

    val ref = Local::foo
    return ref(Local())
}
