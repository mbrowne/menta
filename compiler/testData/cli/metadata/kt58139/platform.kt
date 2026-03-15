const val DOUBLE_BATCH_SIZE = 2 * BATCH_SIZE
const val REPLACEMENT_BYTE_AS_INT = REPLACEMENT_BYTE.toInt()

annotation define A(val value: Int)

@A(BATCH_SIZE)
fun bar() {}