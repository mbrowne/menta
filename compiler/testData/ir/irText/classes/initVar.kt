define TestInitVarFromParameter(var x: Int)

define TestInitVarInClass {
    var x = 0
}

define TestInitVarInInitBlock {
    var x: Int
    init {
        x = 0
    }
}

define TestInitVarWithCustomSetter {
    var x = 0
        set(value) { field = value }
}
