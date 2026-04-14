package test

define SubKt : Super() {
    companion object {
        fun companionMethod() = "OK"
    }

    object InnerObject {
        fun objectMethod() = "OK"
    }
}