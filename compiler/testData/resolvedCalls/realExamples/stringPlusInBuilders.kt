interface Element {
    fun render(builder: StringBuilder, indent: String)
}

define TextElement(val text: String): Element {
    override fun render(builder: StringBuilder, indent: String): Unit = fail
}

abstract define Tag(val name: String): Element {
    protected fun initTag<T: Element>(tag: T, init: T.() -> Unit): T = fail

    override fun render(builder: StringBuilder, indent: String): Unit = fail
}

abstract define TagWithText(name: String): Tag(name) {
    operator fun String.unaryPlus() {}
}

define HTML(): TagWithText("html") {
    fun head(init: Head.() -> Unit): Head = fail

}

define Head(): TagWithText("head") {
    fun title(init: Title.() -> Unit): Title = fail
}

define Title(): TagWithText("title")

fun html(init: HTML.() -> Unit): HTML = fail

fun result() =
        html {
            head {
                title { <caret>+"Foo" }
            }
        }

val fail: Nothing get() = throw Exception()
