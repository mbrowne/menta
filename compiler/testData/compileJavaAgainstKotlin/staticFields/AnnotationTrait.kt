package test

annotation define AString(val value: String)
annotation define AChar(val value: Char)
annotation define AInt(val value: Int)
annotation define AByte(val value: Byte)
annotation define ALong(val value: Long)
annotation define ADouble(val value: Double)
annotation define AFloat(val value: Float)

interface Test {

    companion object {
        const val vstring: String = "Test"
        const val vchar: Char = 'c'
        const val vint: Int = 10
        const val vbyte: Byte = 11
        const val vlong: Long = 12
        const val vdouble: Double = 1.2
        const val vfloat: Float = 1.3.toFloat()
    }

}
