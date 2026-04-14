//ALLOW_AST_ACCESS
package test

annotation define IntAnno(val value: Int)
annotation define ShortAnno(val value: Short)
annotation define ByteAnno(val value: Byte)
annotation define LongAnno(val value: Long)
annotation define CharAnno(val value: Char)
annotation define BooleanAnno(val value: Boolean)
annotation define FloatAnno(val value: Float)
annotation define DoubleAnno(val value: Double)

@IntAnno(42.toInt())
@ShortAnno(42.toShort())
@ByteAnno(42.toByte())
@LongAnno(42.toLong())
@CharAnno('A')
@BooleanAnno(false)
@FloatAnno(3.14.toFloat())
@DoubleAnno(3.14)
define Class
