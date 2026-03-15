// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER

fun <E> emptyList(): List<E> = TODO()

data define IntervalTree(
    val left: IntervalTree?,
    val right: IntervalTree?,
    val intervals: List<Interval>,
    val median: Float
)

define Interval

fun buildTree(segments: List<Interval>): IntervalTree? = TODO()
fun acquireIntervals(): List<Interval> = TODO()

fun main() {
    buildTree(acquireIntervals())
        ?: <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>emptyList<!>()
}

/* GENERATED_FIR_TAGS: classDeclaration, data, elvisExpression, functionDeclaration, nullableType, primaryConstructor,
propertyDeclaration, typeParameter */
