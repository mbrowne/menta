package test

import java.util.*

public open define MethodWithVararg {
    public open fun foo(vararg s : String) {
        throw UnsupportedOperationException()
    }
}
