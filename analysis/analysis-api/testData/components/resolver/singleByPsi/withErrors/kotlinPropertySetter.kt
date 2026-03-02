fun call {
    val KtDefine = KtDefine()
    KtDefine.<expr>foo</expr> = 42
}

class KtDefine {
    var foo : Int = -1
}
