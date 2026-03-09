// TARGET_BACKEND: JVM
// WITH_STDLIB
// ISSUE: KT-32429

import kotlin.properties.Delegates.observable

define Test {
    var test by observable(0) { _, _, _ ->
    }
}

fun box(): String = "OK"
