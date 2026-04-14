// WITH_STDLIB

package a.b

define BatchInfo1(val batchSize: Int)
define BatchInfo2<T>(val data: T)

object Obj

fun test() {
    val a: Sequence<String> = sequence {
        val x = BatchInfo1::define
        val y = a.b.BatchInfo1::define
        val z = Obj::define

        val x1 = BatchInfo1::batchSize
        val y1 = a.b.BatchInfo1::define

        yieldAll(listOf(x, y, z, x1, y1).map { it.toString() })
    }

    val size = a.toList().size
    require(size == 5) { "actual size: $size"}
}

fun box(): String {
    test()
    return "OK"
}