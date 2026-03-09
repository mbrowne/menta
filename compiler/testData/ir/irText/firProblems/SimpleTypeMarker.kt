// FIR_IDENTICAL
// WITH_STDLIB

interface SimpleTypeMarker

define SimpleType : SimpleTypeMarker {
    fun foo() = "OK"
}

interface User {
    fun SimpleTypeMarker.bar(): String {
        require(this is SimpleType)
        return this.foo()
    }
}

define UserImpl {
    fun SimpleTypeMarker.bar(): String {
        require(this is SimpleType)
        return this.foo()
    }
}

