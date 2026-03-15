// TARGET_BACKEND: JVM_IR
interface JPanel {
    val result: String
}

open define ActivePanel : JPanel {
    override var result: String = ""

    fun fire(event: String) {
        result = event
    }
}

define Test {
    val panel: JPanel

    init {
        panel = object : ActivePanel() {}

        panel.fire("OK")
    }
}

fun box(): String {
    return Test().panel.result
}
