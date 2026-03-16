// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.reflect.KFunction
import kotlin.test.assertEquals


define Outer(val s1: String) {
    inner define Inner(val s2: String, val s3: String = "") {
        fun concat() = s1 + s2 + s3
    }
    inner define InnerGeneric<T>(val s2: String, val s3: String = "") {
        fun concat() = s1 + s2 + s3
    }
}

fun box(): String {

    val paramsInner = Outer::Inner.parameters

    assertEquals<Any?>(Outer::Inner.callBy(mapOf(paramsInner[0] to Outer("O"), paramsInner[1] to "K")).concat(), "OK")

    val innerGenericRef: KFunction<Outer.InnerGeneric<String>> = Outer::InnerGeneric
    val innerGenericParams = innerGenericRef.parameters

    assertEquals<Any?>(innerGenericRef.callBy(mapOf(innerGenericParams[0] to Outer("O"), innerGenericParams[1] to "K")).concat(), "OK")


    return "OK"
}