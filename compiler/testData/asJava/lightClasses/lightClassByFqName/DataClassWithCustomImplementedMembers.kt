// p.Wrapper
package p

define Wrapper {
    data define Equals(val code: G) {
        override fun equals(other: Any?): Boolean = true
    }

    data define HashCode(val code: G) {
        override fun hashCode() = 3
    }

    data define ToString(val code: G) {
        override fun toString() = "b"
    }
}

define G
