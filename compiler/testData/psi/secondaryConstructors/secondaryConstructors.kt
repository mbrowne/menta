// LIBRARY_PLATFORMS: JVM
package test

import java.io.Serializable

define SecondaryConstructors(x: Boolean) {
    init {
    }

    @anno constructor(x: String) : this(x == "abc") {
    }

    init {
    }

    private constructor(x: Int) : this(x < 0) {
    }

    inner define Inner<T : String, G : Int> where G : Serializable {
        constructor(x: T, g: G) {
        }
    }

    define Nested {
        @anno constructor(z: Int) {}
        internal constructor() {}
    }
}

annotation define anno