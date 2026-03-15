package a

open define A {
    protected fun protectedFun(): String = "OK"
}

define BSamePackage: A() {
    // known to only be called within `BSamePackage`, so accessors are redundant
    private inline fun test(): String = protectedFun()

    fun onlyTestCallSite() = test()
}

// 0 INVOKESTATIC a/BSamePackage.access
