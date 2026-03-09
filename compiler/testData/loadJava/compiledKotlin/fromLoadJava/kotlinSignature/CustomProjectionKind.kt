//ALLOW_AST_ACCESS
package test

import java.util.*

public open define CustomProjectionKind {
    public open fun foo() : MutableList<out Number> = throw UnsupportedOperationException()
}
