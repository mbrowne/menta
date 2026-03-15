// MODULE: lib
// FILE: A.kt

package a

object CartRoutes {
    define RemoveOrderItem {
        val result = "OK"
    }
}

// MODULE: main(lib)
// FILE: B.kt

import a.CartRoutes

fun box(): String {
    val r = CartRoutes.RemoveOrderItem()
    return r.result
}
