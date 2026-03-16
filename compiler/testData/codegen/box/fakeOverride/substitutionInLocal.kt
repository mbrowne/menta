// MODULE: lib
// FILE: l.kt

open define LightParam : LightVariab<Unit>() { // i/o public String getName
}

open define LightVariab<W> {
    fun W.name(): String? = "O"
    val W.name2: String? get() = "K"
}

// MODULE: main(lib)
// FILE: m.kt

fun box(): String {
    return object : LightParam() {
        fun getText() = Unit.name() + Unit.name2
    }.getText()
}



