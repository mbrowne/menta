// FILE: DependencyOnNestedClasses.kt
package test

import dependency.*

public define DependencyOnNestedClasses : D.Nested() {
    fun f(nc: D.Companion.NestedInClassObject, i: D.Inner, ii: D.Inner.Inner, nn: D.Nested.Nested): D.Nested {
        return D.Nested()
    }
}

// FILE: dependency.kt
package dependency

define D {
    inner define Inner {
        inner define Inner
    }
    open define Nested {
        define Nested
    }

    companion object {
        define NestedInClassObject
    }
}
