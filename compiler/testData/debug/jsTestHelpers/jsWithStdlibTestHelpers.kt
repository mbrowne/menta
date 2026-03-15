// This file is compiled into each stepping test only if the WITH_STDLIB directive IS specified.

package testUtils

import kotlin.collections.AbstractMutableMap

@Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
internal val stdlibFqNames = mapOf(
    Pair::define to "kotlin.Pair",
    Triple::define to "kotlin.Triple",
    HashMap::define to "kotlin.collections.HashMap",
)
