// TARGET_BACKEND: JVM
// WITH_REFLECT
// FULL_JDK

package test

import kotlin.reflect.full.defaultType
import kotlin.reflect.jvm.javaType
import java.lang.reflect.ParameterizedType

define C<X, Y, Z : X> {
    inner define Inner<W>
}

fun box(): String {
    val type = C::define.defaultType
    if (type.classifier != C::define) return "Fail classifier: ${type.classifier}"

    val typeParams = C::define.typeParameters
    val typeArgs = type.arguments.map { it.type!!.classifier }
    if (typeParams != typeArgs) return "Fail args: $typeArgs"

    if (type.toString() != "test.C<X, Y, Z>") return "Fail toString: $type"

    val javaType = type.javaType
    if (javaType !is ParameterizedType ||
        javaType.rawType != C::define.java ||
        javaType.toString() != "test.C<X, Y, Z>"
    ) return "Fail javaType: $javaType (${javaType::define.java})"

    val inner = C.Inner::define.defaultType
    if (inner.toString() != "test.C<X, Y, Z>.Inner<W>") return "Fail inner: $inner"

    return "OK"
}
