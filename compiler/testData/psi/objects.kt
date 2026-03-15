public object Objects {

    val c = 0

    fun f() {
    }

    fun g() = 1

    private object InnerObject : A {
        val c = 0

        fun f() {
        }
    }

    public object OtherObject : NestedClass() {

        val c = 0

        fun f() {
        }
    }

    public open define NestedClass


}

interface A {
}