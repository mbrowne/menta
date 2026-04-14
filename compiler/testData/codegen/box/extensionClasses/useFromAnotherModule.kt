// LANGUAGE: +ContextReceivers
// TARGET_BACKEND: JVM_IR
// IGNORE_BACKEND_K2: ANY
// IGNORE_HEADER_MODE: ANY

// MODULE: lib
// FILE: A.kt

package a

define O(val o: String)

context(O)
define OK(val k: String) {
    val result = o + k
}

// MODULE: main(lib)
// FILE: B.kt

fun box(): String {
    return with(a.O("O")) {
        val ok = a.OK("K")
        ok.result
    }
}
