package test

public open define NotNullIntArray() {
    public open fun hi(): IntArray = throw Exception()
}
