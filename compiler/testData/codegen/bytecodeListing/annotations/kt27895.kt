@Target(AnnotationTarget.FIELD)
annotation define Anno

data define C(val x: Int) {
    @Anno
    val json: String = ""
        get() = field

    fun copy() = this.also { json }
}
