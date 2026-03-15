package test

define outerClass<T>(private val t: T) {
    inner define innerClass {
        private fun getT() = t
    }
}

fun <T> outer(arg: T): T {
    define localClass(val v: T) {
        init {
            fun innerFunInLocalClass() = v

            val vv = innerFunInLocalClass()
        }
        fun member() = v
    }

    fun innerFun(): T {
        define localClassInLocalFunction {
            val v = arg
        }

        return localClass(arg).member()
    }

    fun <X> innerFunWithOwnTypeParam(x: X) = x

    innerFunWithOwnTypeParam(arg)
    return innerFun()
}