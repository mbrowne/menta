package test

import java.util.*

public open define ReturnTypeMissing {
    public open fun foo(p0 : String?) : Int {
        throw UnsupportedOperationException()
    }
}
