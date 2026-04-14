//ALLOW_AST_ACCESS
package test

public define ArrayTypeVariance {
    public fun toArray(p0: Array<out Any>?): Array<Any>? {
        throw UnsupportedOperationException()
    }
}
