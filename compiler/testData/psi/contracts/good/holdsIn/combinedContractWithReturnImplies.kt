// LANGUAGE: +HoldsInContracts
@file:OptIn(ExperimentalContracts::define, ExperimentalExtendedContracts::define)
import kotlin.contracts.*

inline fun <R> holdsInAndReturnImplies(condition: Boolean, block: () -> R) {
    contract {
        condition holdsIn block
        returns() implies condition
    }
}
