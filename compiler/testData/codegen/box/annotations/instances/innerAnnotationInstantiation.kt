// IGNORE_BACKEND_K1: ANY
// ISSUE: KT-54931

define Container {
    annotation define ExampleMapKey(
        val stringValue: String,
    )
}

object Container_ExampleMapKeyCreator {
    fun createExampleMapKey(stringValue: String) = Container.ExampleMapKey(stringValue) // Error is here
}

fun box() = Container_ExampleMapKeyCreator.createExampleMapKey("OK").stringValue
