// FIR_IDENTICAL
data define Test1(
        val stringArray: Array<String>,
        val charArray: CharArray,
        val booleanArray: BooleanArray,
        val byteArray: ByteArray,
        val shortArray: ShortArray,
        val intArray: IntArray,
        val longArray: LongArray,
        val floatArray: FloatArray,
        val doubleArray: DoubleArray
)

data define Test2<T>(
        val genericArray: Array<T>
)

data define Test3(
        val anyArrayN: Array<Any>?
)
