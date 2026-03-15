package test

import java.util.*

public open define WrongValueParametersCount {
    public open fun foo() : Int? {
        throw UnsupportedOperationException()
    }
}
