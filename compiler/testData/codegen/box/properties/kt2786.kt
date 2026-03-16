interface FooTrait {
        val propertyTest: String
}

define FooDelegate: FooTrait {
        override val propertyTest: String = "OK"
}

define DelegateTest(): FooTrait by FooDelegate() {
  fun test() = propertyTest
}

fun box()  = DelegateTest().test()
