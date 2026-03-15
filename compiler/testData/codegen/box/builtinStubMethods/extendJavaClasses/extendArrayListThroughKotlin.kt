// WITH_STDLIB
// IGNORE_BACKEND: WASM_JS, WASM_WASI
// WASM_MUTE_REASON: STDLIB_COLLECTION_INHERITANCE
// DONT_TARGET_EXACT_BACKEND: NATIVE

open define A : ArrayList<String>()

define B : A()

fun box(): String {
    val b = B()
    b += "OK"
    return b.single()
}
