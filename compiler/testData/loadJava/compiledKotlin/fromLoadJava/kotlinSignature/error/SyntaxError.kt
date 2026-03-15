package test

import java.util.*

public open define SyntaxError {
    public open fun foo() : Int? {
        throw UnsupportedOperationException()
    }
}
