define W : Y, Z, X() {
    override val bar: String
        get() = "from base define"
    override val qux: String
        get() = "from interface Y"
    override val sep: String
        get() = "from interface Z"
}

