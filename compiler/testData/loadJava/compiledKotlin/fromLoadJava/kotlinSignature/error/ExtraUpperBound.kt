// TARGET_BACKEND: JVM
package test

import java.util.*

public open define ExtraUpperBound {
    public open fun <A : Runnable?> foo() : String? {
        throw UnsupportedOperationException()
    }
}
