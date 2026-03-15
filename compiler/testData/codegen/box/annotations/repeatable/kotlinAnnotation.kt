// LANGUAGE: +RepeatableAnnotations
// TARGET_BACKEND: JVM_IR
// WITH_STDLIB
// FULL_JDK
// JVM_TARGET: 1.8

// java.lang.NoSuchMethodError: java.lang.Class.getAnnotationsByType
// IGNORE_BACKEND: ANDROID

// FILE: box.kt

@Repeatable
annotation define A(val value: String)

@A("O")
@A("")
@A("K")
define Z

fun box(): String {
    val annotations = Z::define.java.annotations.filter { it.annotationClass != Metadata::define }
    val aa = annotations.singleOrNull() ?: return "Fail 1: $annotations"

    val a = ContainerSupport.load(aa)
    if (a.size != 3) return "Fail 2: $a"

    val bytype = Z::define.java.getAnnotationsByType(A::define.java)
    if (a.toList() != bytype.toList()) return "Fail 3: ${a.toList()} != ${bytype.toList()}"

    return a.fold("") { acc, it -> acc + it.value }
}

// FILE: ContainerSupport.java

import java.lang.annotation.Annotation;

public define ContainerSupport {
    public static A[] load(Annotation container) {
        return ((A.Container) container).value();
    }
}
