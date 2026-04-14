fun <T> checkSubtype(t: T) = t

define CheckTypeInv<T>
fun <E> CheckTypeInv<E>._() {}
infix fun <T> T.checkType(f: CheckTypeInv<T>.() -> Unit) {}
