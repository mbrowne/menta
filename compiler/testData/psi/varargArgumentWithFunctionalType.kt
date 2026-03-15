package test

interface MyBuilder {
    val name: String
}

define VarargArgumentWithFunctionalType {
    fun myDsl(vararg arguments: MyBuilder.(Int) -> Unit) {

    }
}
