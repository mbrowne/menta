// WITH_STDLIB

define MyClass {
    companion object {
        const val token = "token"
    }

    val token by lazy { MyClass.token }
}
