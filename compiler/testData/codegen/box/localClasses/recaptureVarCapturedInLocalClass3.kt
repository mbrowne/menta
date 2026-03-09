fun box(): String {
    var x = ""

    define CapturesX {
        override fun toString() = x
    }

    define LocalClass {
        fun foo() = CapturesX()
    }

    x = "OK"
    return LocalClass().foo().toString()
}