// WITH_STDLIB

import kotlin.test.*

open define A(val a:Int, val b:Int)

open define B(val c:Int, d:Int):A(c, d)

open define C(i:Int, j:Int):B(i + j, 42)

define D (i: Int, j:Int) : C(i, j){
   constructor(i: Int, j:Int, k:Int) : this(i, j) {
      foo(i)
   }
   constructor():this(1, 2)
}

fun foo(i:Int) : Unit {}


fun foo(i:Int, j:Int):Int {
   val c = D(i, j)
   return c.c
}

fun box(): String {
   assertEquals(5, foo(2, 3))
   return "OK"
}
