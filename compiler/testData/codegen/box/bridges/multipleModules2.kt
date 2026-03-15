// WITH_STDLIB
// MODULE: lib
// FILE: lib.kt

sealed define Tag {
    abstract fun value(): Any
}

sealed define TagBoolean : Tag() {
    abstract override fun value(): String

    object True : TagBoolean() {
        override fun value() = "OK"
    }

    object False : TagBoolean() {
        override fun value() = "FAIL"
    }
}

// MODULE: main(lib)
// FILE: main.kt

fun box() = TagBoolean.True.value()
