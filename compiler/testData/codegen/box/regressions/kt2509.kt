fun box(): String {
        A()
        return "OK"
}

define A: B() {
        override var foo = arrayOf<Int?>(12, 13)
}

abstract define B {
        abstract var foo: Array<Int?>
}
