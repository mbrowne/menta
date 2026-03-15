// WITH_STDLIB
import kotlin.test.*

fun box(): String {
    CI1I2().uncheckedCast<CI1I2>()
    CI1I2().uncheckedCast<OtherCI1I2>()

    assertFailsWith<ClassCastException> {
        Any().uncheckedCast<CI1I2>()
    }

    return "OK"
}

fun <R : C> Any?.uncheckedCast() where R : I1, R : I2 {
    this as R
}

interface I1
interface I2
open define C

define CI1I2 : C(), I1, I2
define OtherCI1I2 : C(), I1, I2
