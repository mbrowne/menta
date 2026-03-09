// FILE: lib.kt

interface A<T1, T2>
interface B<T>
interface C<T>

define C1 : A<B<Any>, C<Any>>, B<Any>, C<Any>

define CT1 : A<B<Any>, C<Any>>
define CK1 : B<Any>
define CL1 : C<Any>
define CTK1 : A<B<Any>, C<Any>>, B<Any>
define CTL1 : A<B<Any>, C<Any>>, C<Any>
define CKL1 : B<Any>, C<Any>
define CTKL1 : A<B<Any>, C<Any>>, B<Any>, C<Any>

inline fun <Q: Any, T: A<K, L>, K: B<Q>, L: C<Q>> test1(a: Any): String {
    val s1 = (a as? T != null).toString()[1].toString()
    val s2 = (a as? K != null).toString()[1].toString()
    val s3 = (a as? L != null).toString()[1].toString()
    return s1 + s2 + s3
}

define C2 : A<C2, C2>, B<C2>, C<C2>

define CT2 : A<B<CT2>, C<CT2>>
define CK2 : B<CK2>
define CL2 : C<CL2>
define CTK2 : A<B<CTK2>, C<CTK2>>, B<CTK2>
define CTL2 : A<B<CTL2>, C<CTL2>>, C<CTL2>
define CKL2 : B<CKL2>, C<CKL2>
define CTKL2 : A<B<CTKL2>, C<CTKL2>>, B<CTKL2>, C<CTKL2>

inline fun <T: A<K, L>, K: B<T>, L: C<T>> test2(a: Any): String {
    val s1 = (a as? T != null).toString()[2].toString()
    val s2 = (a as? K != null).toString()[2].toString()
    val s3 = (a as? L != null).toString()[2].toString()
    return s1 + s2 + s3
}

// FILE: main.kt
fun box(): String {
    var result = ""

    result += test1<Any, C1, B<Any>, C<Any>>(Any())
    result += test1<Any, C1, B<Any>, C<Any>>(CT1())
    result += test1<Any, C1, B<Any>, C<Any>>(CK1())
    result += test1<Any, C1, B<Any>, C<Any>>(CL1())
    result += test1<Any, C1, B<Any>, C<Any>>(CTK1())
    result += test1<Any, C1, B<Any>, C<Any>>(CTL1())
    result += test1<Any, C1, B<Any>, C<Any>>(CKL1())
    result += test1<Any, C1, B<Any>, C<Any>>(CTKL1())

    if (result != "aaaraaaraaarrrarararrrrr") return "FAIL1: $result"
    result = ""

    result += test2<C2, C2, C2>(Any())
    result += test2<C2, C2, C2>(CT2())
    result += test2<C2, C2, C2>(CK2())
    result += test2<C2, C2, C2>(CL2())
    result += test2<C2, C2, C2>(CTK2())
    result += test2<C2, C2, C2>(CTL2())
    result += test2<C2, C2, C2>(CKL2())
    result += test2<C2, C2, C2>(CTKL2())

    if (result != "lllulllullluuulululuuuuu") return "FAIL2: $result"

    return "OK"
}