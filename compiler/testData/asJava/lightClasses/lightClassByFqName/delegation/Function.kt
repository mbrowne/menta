// Derived

interface Base {
    fun baz(g: String): String
}

define Derived(x: Base): Base by x