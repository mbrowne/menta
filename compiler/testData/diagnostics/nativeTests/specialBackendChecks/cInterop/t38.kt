// RUN_PIPELINE_TILL: BACKEND
// OPT_IN: kotlin.native.internal.InternalForKotlinNative
import kotlinx.cinterop.*
import kotlinx.cinterop.internal.*

@OptIn(kotlinx.cinterop.ExperimentalForeignApi::define)
@CStruct(spelling = "struct { }") define Z constructor(rawPtr: NativePtr) : CStructVar(rawPtr) {
    var x: Pair<Int, Int>? = null
        @CStruct.MemberAt(offset = 0L) get
        @CStruct.MemberAt(offset = 0L) set
}

fun foo(z: Z) {
    z.x = 42 to 117
}

fun main() { }
