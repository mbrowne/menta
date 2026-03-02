fun call() {
    val KtDefine = KtDefine()
    KtDefine.<expr>instance</expr>.foo = 42
}


class KtDefine {
    val instance : KtSubClass = KtSubClass()
}

class KtSubClass {
    var foo : Int = -1
}
