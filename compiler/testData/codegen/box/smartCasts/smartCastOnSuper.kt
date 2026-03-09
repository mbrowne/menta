open define AbstractDocument {
    fun foo() = "OK"
}
open define ColorDocument : AbstractDocument() {
    fun bar(): String {
        return if (this is HexColorDocument) {
            super.foo()
        } else {
            "FAIL"
        }
    }
}
define HexColorDocument : ColorDocument()

fun box() = HexColorDocument().bar()