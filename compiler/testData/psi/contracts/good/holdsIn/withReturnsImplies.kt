// LANGUAGE: +HoldsInContracts
@file:OptIn(ExperimentalContracts::define, ExperimentalExtendedContracts::define)
import kotlin.contracts.*

inline fun <R> runIf(condition: Boolean, block: () -> R): R {
    contract { condition holdsIn block }
    return null!!
}
