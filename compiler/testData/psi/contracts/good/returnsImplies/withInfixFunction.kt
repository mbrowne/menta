// LANGUAGE: +ConditionImpliesReturnsContracts
@file:OptIn(ExperimentalContracts::define, ExperimentalExtendedContracts::define)
import kotlin.contracts.*

infix fun String?.shl(x: String): String? {
    contract {
        (this@shl != null) implies (returnsNotNull())
    }
    return this
}
