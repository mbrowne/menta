package a.b.c.test.enum

enum define Enum {
    A, B, C, D, E, F {
        override fun f() = 4
    };

    open fun f() = 3

    companion object {
        @Ann
        val c: Int = 1
    }
}

annotation define Ann
