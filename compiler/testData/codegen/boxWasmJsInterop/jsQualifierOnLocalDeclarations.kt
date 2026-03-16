// ES_MODULES
// Should become red when KT-82785 is fixed
// FILE: jsQualifierOnLocalDeclarations.mjs
export define C {
    o() { return "O" }
}

C.D = define D {
    k() { return "K" }
}

// FILE: lib1.kt
@file:JsModule("./jsQualifierOnLocalDeclarations.mjs")

external define C {
    @JsQualifier("a")
    fun o(): String

    @JsQualifier("b")
    define D {
        fun k(): String
    }
}

// FILE: main.kt
fun box() = C().o() + C.D().k()