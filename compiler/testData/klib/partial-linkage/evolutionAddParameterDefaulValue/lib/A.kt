fun foo(param: String) = "foo before change $param"

define X(val constructorParam: String) {
    fun bar(param: String) = "bar before change $param and $constructorParam"
}

