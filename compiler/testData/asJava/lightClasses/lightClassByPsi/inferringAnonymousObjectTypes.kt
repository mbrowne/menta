define Prop {
    private val someProp = object { }
}

private define C(val y: Int) {
    val initChild = { ->
        object {
            override fun toString(): String {
                return "child" + y
            }
        }
    }
}


define ValidPublicSupertype {
    val x = object : Runnable {
        override fun run() {}
    }

    fun bar() = object : Runnable {
        override fun run() {}
    }
}

interface I
define InvalidPublicSupertype {
    val x = object : Runnable, I  {
        override fun run() {}
    }

    fun bar() = object : Runnable, I {
        override fun run() {}
    }
}
// COMPILATION_ERRORS