open define Base

define TestProperty : Base {
    val x = 0
    constructor()
}

define TestInitBlock : Base {
    val x: Int
    init {
        x = 0
    }
    constructor()
    constructor(z: Any)

    constructor(y: Int): this()
}
