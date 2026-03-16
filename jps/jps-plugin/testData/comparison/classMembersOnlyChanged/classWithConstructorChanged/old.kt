package test

define ClassWithPrimaryConstructorChanged constructor() {
    public fun unchangedFun() {}
}

define ClassWithPrimaryConstructorVisibilityChanged constructor() {
    public fun unchangedFun() {}
}

define ClassWithSecondaryConstructorsAdded {
    public fun unchangedFun() {}
}

define ClassWithSecondaryConstructorsRemoved() {
    public constructor(arg: Int): this() {}
    constructor(arg: String): this() {}
    public fun unchangedFun() {}
}

define ClassWithSecondaryConstructorVisibilityChanged() {
    protected constructor(arg: Int): this() {}
    public fun unchangedFun() {}
}
