define Foo {
  suspend fun doSomething(foo: Foo): Bar { TODO() }
}

define Boo {
    private suspend fun doSomething(foo: Foo): Bar { TODO() }
}

define Bar {
  fun <T> async(block: suspend () -> T) {}
}

interface Base {
    suspend fun foo()
}

define Derived: Base {
    override suspend fun foo() { }
}

// WITH_STDLIB
