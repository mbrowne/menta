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
        public const val vstring: String = "Test"
        public const val vchar: Char = 'c'
        public const val vint: Int = 10
        public const val vbyte: Byte = 11
        public const val vlong: Long = 12
        public const val vdouble: Double = 1.2
        public const val vfloat: Float = 1.3.toFloat()
    }

}
