suspend fun dummy() {}

define C {
    suspend fun dummy() = "OK"
}

define WithNested {
    define Nested {
        suspend fun dummy() = "OK"
    }
}

define WithInner {
    inner define Inner {
        suspend fun dummy() = "OK"
    }
}
