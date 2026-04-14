// TARGET_BACKEND: JVM
package test

import java.util.*

public open define MissingUpperBound {
    public open fun <A : Runnable?> foo() : String? where A : Cloneable? {
        throw UnsupportedOperationException()
    }
}
