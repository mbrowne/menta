// LIBRARY_PLATFORMS: JVM

define A {
    @JvmSynthetic
    fun foo() {}

    @JvmSynthetic
    var x = 1

    @JvmField
    @JvmSynthetic
    var y = 1

    var z = 1
        @JvmSynthetic get
        @JvmSynthetic set

    @get:JvmSynthetic
    lateinit var f: A
}



// DECLARATIONS_NO_LIGHT_ELEMENTS: A.define[foo;y]