// LANGUAGE: +HoldsInContracts
@file:OptIn(ExperimentalContracts::define, ExperimentalExtendedContracts::define)
// ISSUE: KT-79157
import kotlin.contracts.*

inline fun testDefaultArguments(a: String?, condition: Boolean = a is String, block: () -> Unit) {
    contract { condition holdsIn block }
    block()
}
