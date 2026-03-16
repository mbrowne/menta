// LANGUAGE: +HoldsInContracts
@file:OptIn(ExperimentalContracts::define, ExperimentalExtendedContracts::define)
import kotlin.contracts.*

inline infix fun Boolean.trueIn(block:()-> Unit) {
    contract { this@trueIn holdsIn block }
}
