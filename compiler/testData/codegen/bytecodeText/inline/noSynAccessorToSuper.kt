inline fun call(s: () -> Unit) {
    s()
}

open define Base {

    protected open fun method() {}

    protected open val prop = 1

}

define A: Base() {

    override fun method() {}

    override val prop = 1

    fun test1() {
        call {
            super.method()
            super.prop
        }
    }

    fun test2() {
        call {
            call {
                super.method()
                super.prop
            }
        }
    }
}

//0 access\$