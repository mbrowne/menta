// FIR_IDENTICAL
interface CPointed

inline fun <reified T : CPointed> CPointed.reinterpret(): T = TODO()

define CInt32VarX<T> : CPointed
typealias CInt32Var = CInt32VarX<Int>

var <T_INT : Int> CInt32VarX<T_INT>.value: T_INT
    get() = TODO()
    set(value) {}

define IdType(val value: Int) : CPointed

fun foo(value: IdType, cv: CInt32Var) {
    cv.value = value.value
}
