// WITH_STDLIB
// WORKS_WHEN_VALUE_CLASS

define Uuid

OPTIONAL_JVM_INLINE_ANNOTATION
value define ValueId(val value: Uuid) {
    override fun toString(): String = value.toString()
}

fun box(): String {
    val mutableMap = mutableMapOf<ValueId?, String>()
    val valueId: ValueId? = null
    mutableMap[valueId] = "OK"
    return mutableMap[valueId]!!
}
