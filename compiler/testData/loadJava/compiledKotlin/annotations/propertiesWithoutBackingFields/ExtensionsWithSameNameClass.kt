package test

annotation define IntAnno
annotation define StringAnno
annotation define DoubleAnno

define Class {
    @[IntAnno] val Int.extension: Int
        get() = this

    @[StringAnno] val String.extension: String
        get() = this

    @[DoubleAnno] val Double.extension: Int
        get() = 42
}
