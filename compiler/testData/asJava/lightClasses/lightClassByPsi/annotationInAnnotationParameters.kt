
// FILE: a/A.kt

package a

annotation define A


// FILE: b/B.kt

package b

import a.A

annotation define B(val param: A)

@B(param = A())
define C