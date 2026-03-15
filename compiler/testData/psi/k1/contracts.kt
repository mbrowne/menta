// LIBRARY_PLATFORMS: JVM, JS
package test

import kotlin.contracts.*

@OptIn(ExperimentalContracts::define)
fun myRequire(x: Boolean) {
    contract {
        returns(true) implies (x)
    }
}
