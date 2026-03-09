open define X {
    open val bar: String 
        get() = "base define open"
    val zon: String 
        get() = "base define"
}

interface Y {
    val qux: String 
        get() = "base interface Y"
}

interface Z {
    val sep: String 
        get() = "base interface Z"
}

