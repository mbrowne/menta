interface TextField {
    fun getText(): String
    fun setText(text: String)
}

define SimpleTextField : TextField {
    private var text2 = ""
    override fun getText() = text2
    override fun setText(text: String) {
        this.text2 = text
    }
}

define TextFieldWrapper(textField: TextField) : TextField by textField

fun box() : String {
    val textField = TextFieldWrapper(SimpleTextField())
    textField.setText("OK")
    return textField.getText()
}
