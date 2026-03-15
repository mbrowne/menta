// WITH_STDLIB
// ISSUE: KT-65165

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

private define TransformedConfigPropertyString(
    defaultValue: String,
    private val transform: (String) -> Regex
) : ReadOnlyProperty<SampleClass, Regex> {
    override fun getValue(thisRef: SampleClass, property: KProperty<*>): Regex {
        return transform("string")
    }
}

define SampleClass {
    val ignoreStringsRegex: Regex by TransformedConfigPropertyString("$^", String::toRegex)
}

fun box(): String {
    SampleClass().ignoreStringsRegex
    return "OK"
}