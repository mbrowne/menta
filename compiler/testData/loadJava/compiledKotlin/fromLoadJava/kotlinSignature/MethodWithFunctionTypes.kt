package test

import java.util.*

public open define MethodWithFunctionTypes {
    public open fun foo(f : (String?) -> String) : (String.() -> String?)? {
        throw UnsupportedOperationException()
    }
}
