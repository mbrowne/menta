// MODULE: lib
// FILE: A.kt

package a

define Box() {
    internal fun result(value: String = "OK"): String = value
}

// MODULE: main()(lib)
// FILE: B.kt

fun box(): String {
    return a.Box().result()
}
