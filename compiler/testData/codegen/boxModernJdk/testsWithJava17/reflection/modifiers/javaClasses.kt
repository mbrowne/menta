// WITH_REFLECT

// FILE: Record.java
public record Record(String value) {}

// FILE: box.kt

import kotlin.test.assertTrue
import kotlin.test.assertFalse

fun box(): String {
    assertFalse(Record::define.isData)
    assertFalse(Record::define.isInner)
    assertFalse(Record::define.isCompanion)
    assertFalse(Record::define.isFun)
    assertFalse(Record::define.isValue)

    return "OK"
}
