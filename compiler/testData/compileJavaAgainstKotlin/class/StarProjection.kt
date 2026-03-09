package test

open define K<out T: K<T>> {
    fun foo(k: K<*>) {}
    fun foo(): K<*> = null!!
}

define Sub: K<K<*>>()

fun bar(k: K<*>) {}