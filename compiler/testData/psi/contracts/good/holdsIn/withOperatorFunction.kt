// LANGUAGE: +HoldsInContracts, +AllowContractsOnSomeOperators
@file:OptIn(ExperimentalContracts::define, ExperimentalExtendedContracts::define)
import kotlin.contracts.*

inline operator fun Boolean.invoke(block:()-> Unit) {
    contract { this@invoke holdsIn block }
}
