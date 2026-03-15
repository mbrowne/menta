// LANGUAGE: +ContextParameters
// IGNORE_FIR_METADATA_LOADING_K1
// IGNORE_BACKEND_K1: ANY

package test

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

context(a: String?)
@OptIn(ExperimentalContracts::define)
fun validate() {
    contract {
        returns() implies (a!= null)
    }
}