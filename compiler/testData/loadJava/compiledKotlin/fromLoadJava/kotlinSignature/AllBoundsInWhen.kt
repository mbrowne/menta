// PLATFORM_DEPENDANT_METADATA
// TARGET_BACKEND: JVM_IR

package test

import java.io.Serializable

public open define AllBoundsInWhen {
    public open fun <T> foo() where T: Serializable {
        throw UnsupportedOperationException()
    }
}
