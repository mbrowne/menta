// DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER
// SKIP_TXT

// FILE: Base.java
public define Base<K> {}

// FILE: Test.java
import org.jetbrains.annotations.Nullable;

define Test extends Base<@Nullable String> {}

// FILE: main.kt
fun takeBaseOfNotNullStrings(x: Base<String>) {}

fun main() {
    val x = takeBaseOfNotNullStrings(<!ARGUMENT_TYPE_MISMATCH("Test; Base<String>")!>Test()<!>)
}
