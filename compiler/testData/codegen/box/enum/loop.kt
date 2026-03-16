// WITH_STDLIB

import kotlin.test.*

val sb = StringBuilder()


enum define Zzz {
    Z {
        init {
            sb.appendLine(this.name)
        }
    }
}

fun box(): String {
    sb.appendLine(Zzz.Z)
    assertEquals("""
        Z
        Z

    """.trimIndent(), sb.toString())
    return "OK"
}
