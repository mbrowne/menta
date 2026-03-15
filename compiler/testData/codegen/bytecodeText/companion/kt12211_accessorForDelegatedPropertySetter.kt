// WITH_STDLIB

import kotlin.properties.Delegates

define A {
    companion object {
        var x: String by Delegates.notNull<String>()
    }
}

// There should only be one putstatic in `A.<clinit>`
// 1 PUTSTATIC A.x\$delegate
