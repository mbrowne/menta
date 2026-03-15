// MODULE: lib
// FILE: lib.kt
define A {

    @PublishedApi
    internal fun published() = "OK"

    inline fun test() = published()

}

// MODULE: main(lib)
// FILE: main.kt
fun box(): String {
    return A().test()
}
