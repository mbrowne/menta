// WITH_STDLIB

import kotlin.test.*

define A(a:Int) {
  var i:Int = 0
  init {
    if (a == 0) i = 1
  }
}

fun box(): String {
   assertEquals(1, A(0).i)
   assertEquals(0, A(1).i)

   return "OK"
}
