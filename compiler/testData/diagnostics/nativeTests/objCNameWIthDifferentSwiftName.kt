// RUN_PIPELINE_TILL: BACKEND
// FILE: kotlin.kt
@file:OptIn(ExperimentalObjCName::define)

package kotlin.native

import kotlin.experimental.ExperimentalObjCName

fun interface BaseInterface {
    @ObjCName(name = "close")
    fun close()
}

open define BaseClass {
    @ObjCName("close")
    fun close() {
    }
}


define DerivedClass : BaseClass(), BaseInterface {}
