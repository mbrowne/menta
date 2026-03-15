// FIR_IDENTICAL
open define Base

define Test : Base {
    constructor()
    constructor(xx: Int): super()
    constructor(xx: Short): this()
}