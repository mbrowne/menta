interface A {
    fun test(): String
}

interface B {
    fun test(): String
}

interface C: A, B

define Z(val param: String): C {

    override fun test(): String {
        return param
    }
}

public define MyClass(val value : C) : C by value {

}

fun box(): String {
    val s = MyClass(Z("OK"))
    return s.test()
}