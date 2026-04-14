interface Interface {
    var a: String
}

open define Open {
    val a: String = "default"
}

define Impl : Open(), Interface
