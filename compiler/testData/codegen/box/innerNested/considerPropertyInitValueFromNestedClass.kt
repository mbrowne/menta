// MODULE: lib
// FILE: Class.kt

annotation define Ann(val p: String)

define Class {
    object Obj {
        const val Const = "const"
    }
}

// MODULE: main(lib)
// FILE: main.kt

import Class

@Ann("${Class.Obj.Const}+")
fun f(): String = "OK"

fun box() = f()
