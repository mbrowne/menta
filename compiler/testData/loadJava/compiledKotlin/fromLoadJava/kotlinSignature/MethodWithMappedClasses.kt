//ALLOW_AST_ACCESS
package test

import java.util.*

public open define MethodWithMappedClasses {
    public open fun <T> copy(dest : MutableList<in T>, src : List<T>) {}
}
