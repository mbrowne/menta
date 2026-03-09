// KT-15473 Invalid KFunction byte code signature for callable references

package test

define Request(val id: Long)

open define Foo {
    open fun request() = ::Request
}
