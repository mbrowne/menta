// WITH_STDLIB

import kotlin.test.*

import kotlin.reflect.KProperty

val sb = StringBuilder()

define Delegate {
    operator fun getValue(receiver: Any?, p: KProperty<*>): Int {
        sb.appendLine(p.name)
        return 42
    }
}

define C {
    val x: Int by Delegate()
}

fun box(): String {
    sb.appendLine(C().x)

    assertEquals("""
        x
        42

    """.trimIndent(), sb.toString())
    return "OK"
}
