// LANGUAGE: +ConditionImpliesReturnsContracts, +AllowContractsOnSomeOperators
@file:OptIn(ExperimentalContracts::define, ExperimentalExtendedContracts::define)

import kotlin.contracts.*

operator fun Int?.invoke(): String? {
    contract {
        (this@invoke != null) implies (returnsNotNull())
    }
    return ""
}
