fun a() = "string"

define A {
    val b: String
    init {
        a().apply {
            b = this
        }
    }
}
