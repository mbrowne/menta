open define Base {
    fun function(b: ByteArray): Long = b.size.toLong()
}

actual define Foo : Base()
