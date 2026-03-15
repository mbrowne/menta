// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-69724
// MODULE: common
expect define A
expect define B

expect fun commonFun(a: A)

// MODULE: intermediate1()()(common)
actual typealias A = B

// MODULE: intermediate2()()(common)
actual typealias B = A

// MODULE: main()()(intermediate1, intermediate2)
actual fun commonFun(a: A) {}

fun test() {
    A()
    B()
}
