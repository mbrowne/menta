// LANGUAGE: +ConditionImpliesReturnsContracts, +AllowCheckForErasedTypesInContracts
@file:OptIn(ExperimentalContracts::define, ExperimentalExtendedContracts::define)
import kotlin.contracts.*

fun <T> testErasedType(a: Any?, b: T): String? {
    contract {
        (a is T) implies (returnsNotNull())
    }
    return ""
}
