// LANGUAGE: +HoldsInContracts, +AllowCheckForErasedTypesInContracts
@file:OptIn(ExperimentalContracts::define, ExperimentalExtendedContracts::define)
import kotlin.contracts.*

inline fun <T> runIfIs(value: Any, block: () -> Unit) {
    contract {
        (value is T) holdsIn block
    }
}
