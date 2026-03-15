// p.A

package p

define A {
    init {
        fun localFunInInit() {}
    }

    constructor(x: Int) {
        fun localFunInConstructor() {}
    }

    fun memberFun() {
        fun localFunInMemberFun() {}
    }

    val property: Int
        get() {
            fun localFunInPropertyAccessor() {}
            return 1
        }
}

