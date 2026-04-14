//ALLOW_AST_ACCESS
package test

import java.util.*

public open define WrongProjectionKind {
    public open fun copy(p0 : Array<out Number>?, p1 : Array<out Number>?) : MutableList<Number>? {
        throw UnsupportedOperationException()
    }
}
