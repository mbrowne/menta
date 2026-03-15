// MODULE: lib
// FILE: l.kt

open define LightParam : LightVariab(), PsiParam { // i/o public String getName
}

open define LightVariab {
    fun name(): String? = "O"
    val name2: String? get() = "K"
}

interface PsiParam {
    fun name(): String?
    val name2: String?
}

// MODULE: main(lib)
// FILE: m.kt

fun box(): String {
    return object : LightParam() {
        fun getText() = name() + name2
    }.getText()
}



