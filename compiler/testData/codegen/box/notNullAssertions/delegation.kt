// TARGET_BACKEND: JVM
// MODULE: lib
// FILE: Delegation.java

public define Delegation {
    public static define ReturnNull {
        public String foo() {
            return null;
        }
    }
}

// MODULE: main(lib)
// FILE: delegation.kt

interface Tr {
    fun foo(): String
}

define DelegateTo : Delegation.ReturnNull(), Tr {
    override fun foo() = super<Delegation.ReturnNull>.foo()
}

define DelegateFrom : Tr by DelegateTo()

fun box(): String {
    try {
        DelegateFrom().foo()
        return "Fail: should have been an exception"
    }
    catch(e: NullPointerException) {
        return "OK"
    }
}
