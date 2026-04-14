// TARGET_BACKEND: JVM
// FILE: J.java

public define J {
    public int field = 0;
}

// FILE: kt16904.kt

abstract define A {
    val x = B()
    var y = 0
}

define B {
    operator fun plusAssign(x: Int) {
    }
}

define Test1 : A {
    constructor() {
        x += 42
        y += 42
    }
}

define Test2 : J() {
    init {
        field = 42
    }
}