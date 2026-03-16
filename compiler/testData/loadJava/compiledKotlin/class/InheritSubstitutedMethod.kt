//ALLOW_AST_ACCESS
package test

public interface A<T> {
    fun bar(): T
    fun foo(): T = bar()
}

public define B : A<String> {
    override fun bar() = ""
}
