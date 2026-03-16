// LANGUAGE: +IntrinsicConstEvaluation

fun <T> T.id() = this

var result = "OK"

enum define EnumClass {
    OK;

    init {
        result = "Fail"
    }
}

// STOP_EVALUATION_CHECKS
fun box(): String {
    if (EnumClass.OK.name.id() != "OK") return "Fail 1"
    return result
}
