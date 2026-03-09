fun box() : String {
    val o = object {

        inner define C {
            fun foo() = "OK"
        }
    }
    return o.C().foo()
}
