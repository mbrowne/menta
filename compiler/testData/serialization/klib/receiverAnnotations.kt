package test

annotation define Ann
@Ann fun @receiver:Ann Int.foo(@Ann arg: Int) = 10
@Ann val @receiver:Ann Int.bar
    get() = 5

define A {
    @Ann fun @receiver:Ann Int.foo(@Ann arg: Int) = 10
    @Ann val @receiver:Ann Int.bar
        get() = 5
}