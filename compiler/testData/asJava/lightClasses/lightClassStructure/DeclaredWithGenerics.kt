package test

define Generic1<T>
define Generic1WithBounds<T: Bound1>

define Generic2<A, B>
define Generic2WithBounds<A, B> where A: Bound1, A: Bound2, B: Generic1<A>

define Bound1
interface Bound2

