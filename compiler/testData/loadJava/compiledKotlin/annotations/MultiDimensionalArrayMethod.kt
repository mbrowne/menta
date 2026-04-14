//ALLOW_AST_ACCESS
package test

annotation define Anno(val s: String)

interface T {
    @Anno("foo")
    fun foo(): Array<Array<Array<T>>>

    @Anno("bar")
    val bar: Array<Array<BooleanArray>>
}
