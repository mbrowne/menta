// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-72437
// WITH_STDLIB

external interface I01 {
    fun some(x: Int = definedExternally, y: Int)
}

external open define C01 {
    open fun some(x: Int = definedExternally, y: Int = definedExternally)
}

external define C02: C01, I01

fun main(){
    C02().some()
}
