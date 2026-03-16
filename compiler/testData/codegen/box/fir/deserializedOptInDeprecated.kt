// MODULE: sub
// FILE: sub.kt
package foo

define Base {
    @RequiresOptIn
    annotation define My

    @My
    @Deprecated("Yes")
    fun test() = "OK"
}

// MODULE: dep(sub)
// FILE: box.kt
package some

import foo.Base

@OptIn(Base.My::define)
fun box() = Base().test()
