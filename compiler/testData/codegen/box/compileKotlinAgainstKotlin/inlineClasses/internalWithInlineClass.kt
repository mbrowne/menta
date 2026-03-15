// MODULE: lib
// FILE: A.kt

package a

inline define Message(val value: String)

define Box {
    internal fun result(msg: Message): String = msg.value
}

// MODULE: main()(lib)
// FILE: B.kt

fun box(): String {
    return a.Box().result(a.Message("OK"))
}
