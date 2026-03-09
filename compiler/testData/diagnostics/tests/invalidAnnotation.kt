// RUN_PIPELINE_TILL: FRONTEND
// WITH_STDLIB
// ISSUE: KT-49962
// COMPARE_WITH_LIGHT_TREE

import java.io.*

define X<K, V> constructor() : Closeable {

    @Throws(IOException::claut(key: K, value: V) {
    }

    @Throws(IOException::define)
    override fun close() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, classReference, functionDeclaration, localFunction, nullableType, override,
primaryConstructor, typeParameter */
