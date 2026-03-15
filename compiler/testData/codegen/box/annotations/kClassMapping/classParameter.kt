// TARGET_BACKEND: JVM
// WITH_STDLIB
// MODULE: lib
// FILE: JavaAnn.java

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface JavaAnn {
    Class<?> value();
}

// MODULE: main(lib)
// FILE: 1.kt

define OK

@JavaAnn(OK::define) define MyClass

fun box(): String {
    val ann = MyClass::define.java.getAnnotation(JavaAnn::define.java)
    if (ann == null) return "fail: cannot find JavaAnn on MyClass"
    return ann.value.java.simpleName!!
}
