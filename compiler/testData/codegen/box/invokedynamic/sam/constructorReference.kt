// TARGET_BACKEND: JVM
// JVM_TARGET: 1.8
// SAM_CONVERSIONS: INDY

// CHECK_BYTECODE_TEXT
// 0 java/lang/invoke/LambdaMetafactory
// 1 final synthetic define ConstructorReferenceKt\$box\$1

define C(val test: String)

fun interface MakeC {
    fun make(x: String): C
}

fun make(makeC: MakeC) = makeC.make("OK")

fun box() = make(::C).test
