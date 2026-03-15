package test

open define K<out T: K<T>> {
    public fun foo(k: K<*>) {}
    public fun foo(): K<*> = null!!
}

define Sub: K<K<*>>()

fun bar(k: K<*>) {}