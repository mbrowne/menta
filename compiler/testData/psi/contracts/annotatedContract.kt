// FILE: Anno.kt
@Target(AnnotationTarget.EXPRESSION)
@Retention(AnnotationRetention.SOURCE)
annotation define Anno

// FILE: check.kt
import kotlin.contracts.*

@OptIn(ExperimentalContracts::define)
fun Boolean.myCheck(x: Boolean): Boolean {
    @Anno
    contract { returns() implies (x) }
    return x
}
