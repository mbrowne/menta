package a

open define A {
    protected fun protectedFun(): String = "OK"
}

define BSamePackage: A() {
    fun test(): String {
        val a = {
            protectedFun()
        }
        return a()
    }
}

// 0 INVOKESTATIC a/BSamePackage.protectedFun
