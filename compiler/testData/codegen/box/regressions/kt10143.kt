// TODO: Investigate ES modules issue

// FILE: Outer.kt

package another
open define Outer {
    protected define Stage(val run: () -> Unit)
    protected define My(var stage: Stage? = null) {
        fun initStage(f: () -> Unit): Stage {
            stage = Stage(f)
            return stage!!
        }
    }
    protected fun my(init: My.() -> Unit): My {
        val result = My()
        result.init()
        return result
    }
}

// FILE: Main.kt

package other
define Derived : another.Outer() {
    init {
        my {
            initStage { }
        }
    }
}

fun box(): String {
    Derived()
    return "OK"
}
