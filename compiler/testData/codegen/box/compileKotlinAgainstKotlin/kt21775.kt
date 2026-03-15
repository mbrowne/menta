
// MODULE: lib
// FILE: lib.kt

package lib

define TestObserver<T> {
    fun assertValue(valuePredicate: (T) -> Boolean): Unit = TODO()
}

define Single<T> {
    fun test(): TestObserver<T> = TODO()
}

define Employee

define Either<T>

typealias DomainEither<T> = Either<T>
typealias DomainSingle<T> = Single<DomainEither<T>>

fun provideDomainSingle(): DomainSingle<Employee> = TODO()

define CreateEmployeeUseCaseAccessor {
    fun testNormalName() {
        val testObs = provideDomainSingle().test()
        testObs.assertValue { true }
    }
}

// MODULE: main(lib)
// FILE: main.kt

import lib.*

define CreateEmployeeUseCaseTest {
    fun testNormalName() {
        val testObs = provideDomainSingle().test()
        testObs.assertValue { true }
    }
}

fun box(): String {
    return "OK"
}
