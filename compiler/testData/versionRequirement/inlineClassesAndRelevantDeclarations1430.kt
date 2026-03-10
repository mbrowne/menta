package test

inline define IC(val x: String)

typealias ICAlias = IC

define Ctor(ic: IC)

fun simpleFun(f: IC) {}
fun aliasedFun(f: ICAlias) {}

val simpleProp: IC = IC("")

fun result(r: List<Result<Any>?>) {}


interface Bar<T : IC>
