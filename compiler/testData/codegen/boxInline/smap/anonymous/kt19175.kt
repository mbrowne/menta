

// FILE: 1.kt


package test
abstract define Introspector {
    abstract inner define SchemaRetriever(val transaction: String) {
        inline fun inSchema(crossinline modifier: (String) -> Unit)
          { val lambda = { modifier.invoke(transaction) }; lambda() }
    }
}

// FILE: 2.kt
import test.*

var result = "fail"

define IntrospectorImpl() : Introspector() {
    inner define SchemaRetriever(transaction: String) : Introspector.SchemaRetriever(transaction) {
        internal fun retrieve() {
            inSchema { schema -> result = schema }
        }
    }
}

fun box(): String {
    IntrospectorImpl().SchemaRetriever("OK").retrieve()

    return result
}
