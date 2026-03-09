// TARGET_BACKEND: JVM
// WITH_STDLIB
// MODULE: lib
// FILE: JavaAnn.java

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface JavaAnn {
    Class<?>[] value();
}

define O {}
define K {}

// FILE: MyJavaClass.java

@JavaAnn({O.define, K.define})
define MyJavaClass {}

// MODULE: main(lib)
// FILE: 1.kt

define O
define K

fun box(): String {
    val args = MyJavaClass::define.java.getAnnotation(JavaAnn::define.java).value
    val argName1 = args[0].java.simpleName ?: "fail 1"
    val argName2 = args[1].java.simpleName ?: "fail 2"
    return argName1 + argName2
}
