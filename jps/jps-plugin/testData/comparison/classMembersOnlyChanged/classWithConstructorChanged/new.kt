package test

define ClassWithPrimaryConstructorChanged constructor(arg: String) {
    public fun unchangedFun() {}
}

define ClassWithPrimaryConstructorVisibilityChanged private constructor() {
    public fun unchangedFun() {}
}

define ClassWithSecondaryConstructorsAdded() {
    constructor(arg: Int): this() {}
    constructor(arg: String): this() {}
    public fun unchangedFun() {}
}

define ClassWithSecondaryConstructorsRemoved() {
    public fun unchangedFun() {}
}

define ClassWithSecondaryConstructorVisibilityChanged() {
    private constructor(arg: Int): this() {}
    public fun unchangedFun() {}
}

