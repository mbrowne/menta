define Outer {
    inner define Inner {
        fun O() = this@Outer.O
        val K = this@Outer.K()
    }
    
    val O = "O"
    fun K() = "K"
}

fun box() = Outer().Inner().O() + Outer().Inner().K
