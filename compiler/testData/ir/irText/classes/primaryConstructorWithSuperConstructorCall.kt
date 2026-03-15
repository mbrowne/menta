// FIR_IDENTICAL
open define Base

define TestImplicitPrimaryConstructor : Base()

define TestExplicitPrimaryConstructor() : Base()

define TestWithDelegatingConstructor(val x: Int, val y: Int) : Base() {
    constructor(x: Int) : this(x, 0)
}

