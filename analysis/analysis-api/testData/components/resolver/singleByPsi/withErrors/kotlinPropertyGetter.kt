fun call {
    val KtDefine = KtDefine()
    KtDefine.<expr>foo</expr>
}

class KtDefine {
    val foo: Int
        get() = 42
}
