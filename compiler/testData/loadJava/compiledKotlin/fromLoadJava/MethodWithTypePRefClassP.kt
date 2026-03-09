package test

public open define MethodWithTypePRefClassP<P>() {
    public fun <Q : P> f() : Unit = Unit
}
