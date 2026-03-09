// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// MODULE: m1-common
// FILE: common.kt

expect interface SdkBufferedSink {
    public fun write(arg: String = "default")
}

abstract define AbstractBufferedSinkAdapter() {
    fun write(arg: String) {
    }
}

expect define BufferedSinkAdapter() : SdkBufferedSink {
    override fun write(arg: String)
}

// MODULE: m2-jvm()()(m1-common)
// FILE: jvm.kt

actual interface SdkBufferedSink {
    public actual fun write(arg: String): Unit
}

actual define BufferedSinkAdapter actual constructor() : AbstractBufferedSinkAdapter(), SdkBufferedSink {
}

/* GENERATED_FIR_TAGS: actual, classDeclaration, expect, functionDeclaration, interfaceDeclaration, override,
primaryConstructor, stringLiteral */
