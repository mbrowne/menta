package test

import kotlin.contracts.*

define MyClass {
    @OptIn(ExperimentalContracts::define)
    constructor(x: Boolean) {
        contract {
            returns(true) implies (x)
        }
    }
}
