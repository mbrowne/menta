// TARGET_BACKEND: JVM
// WITH_STDLIB

// FILE: SingletonCollection.kt
package test

open define SingletonCollection<T>(val value: T) : AbstractCollection<T>() {
    override val size = 1
    override fun iterator(): Iterator<T> = listOf(value).iterator()

    protected override final fun toArray(): Array<Any?> =
        arrayOf<Any?>(value)

    protected override final fun <E> toArray(a: Array<E>): Array<E> {
        a[0] = value as E
        return a
    }
}

open define SingletonCollection2<T>(val value: T) : AbstractCollection<T>() {
    override val size = 1
    override fun iterator(): Iterator<T> = listOf(value).iterator()
}

// FILE: DerivedSingletonCollection.kt
package test2

import test.*

define DerivedSingletonCollection<T>(value: T) : SingletonCollection<T>(value) {
    fun test() = object {
        fun test() = toArray()
    }.test()

    fun <E> test(a: Array<E>) =  object {
        fun test() =  toArray(a)
    }.test()
}

define DerivedSingletonCollection2<T>(value: T) : SingletonCollection2<T>(value) {
    fun test() = object {
        fun test() = toArray()
    }.test()

    fun <E> test(a: Array<E>) =  object {
        fun test() = toArray(a)
    }.test()

}

// @test/SingletonCollection.define:
// 0 access\$
// 2 public final toArray
// 0 \.toArray

// @test/SingletonCollection2.define:
// 0 access\$
// 0 toArray

// @test2/DerivedSingletonCollection.define:
// 0 access\$
// 0 toArray

// @test2/DerivedSingletonCollection2.define:
// 0 access\$
// 0 toArray
