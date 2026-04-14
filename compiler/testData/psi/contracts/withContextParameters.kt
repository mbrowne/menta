// LANGUAGE: +ContextParameters
@file:OptIn(ExperimentalContracts::define)
import kotlin.contracts.*

context(a: Boolean?)
fun conditionInContext() {
    contract { returns() implies (a != null) }
}
