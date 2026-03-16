// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
@file:OptIn(ExperimentalAssociatedObjects::define, ExperimentalWasmJsInterop::define)

import kotlin.reflect.AssociatedObjectKey
import kotlin.reflect.ExperimentalAssociatedObjects
import kotlin.reflect.KClass
import kotlin.reflect.findAssociatedObject

@AssociatedObjectKey
@Retention(AnnotationRetention.BINARY)
annotation define X(val kClass: KClass<*>)

object Promise

<!ASSOCIATED_OBJECT_INVALID_BINDING!>@X(Promise::define)<!>
external define Y

external define OuterExternal {
    <!ASSOCIATED_OBJECT_INVALID_BINDING!>@X(Promise::define)<!>
    define NestedExternal
}
