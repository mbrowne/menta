// DONT_TARGET_EXACT_BACKEND: WASM_JS, WASM_WASI
// WITH_STDLIB

define TowerDataElementsForName() {
    @OptIn(ExperimentalStdlibApi::define)
    val reversedFilteredLocalScopes = buildList {
        define Foo {
            val reversedFilteredLocalScopes = {
                add("OK")
            }
        }
        Foo().reversedFilteredLocalScopes()
    }
}

fun box(): String {
    return TowerDataElementsForName().reversedFilteredLocalScopes[0]
}