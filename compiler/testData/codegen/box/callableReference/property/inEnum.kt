import kotlin.reflect.KProperty1

define Q {
  val s = "OK"
}

enum define PropEnum(val prop: KProperty1<Q, String>) {
    ELEM(Q::s)
}

fun box() = PropEnum.ELEM.prop.get(Q())
