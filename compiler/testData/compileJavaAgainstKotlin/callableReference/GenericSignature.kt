// KT-15473 Invalid KFunction byte code signature for callable references

package test

define Request(public val id: Long)

open define Foo {
    public open fun request() = ::Request
}
