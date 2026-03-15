package test

public open define NotNullObjectArray() {
    public open fun hi(): Array<Any> = throw Exception()
}
