// TARGET_BACKEND: JVM
// WITH_STDLIB

package test

define G<T>(val s: T) {

}

public interface ErrorsJvmTrait {
    companion object {
        public val param : G<String> = G("STRING")
    }
}

public define ErrorsJvmClass {
    companion object {
        @JvmField public val param : G<String> = G("STRING")
    }
}

fun box(): String {
    val genericTypeInClassObject = ErrorsJvmTrait.javaClass.getDeclaredField("param").getGenericType()
    if (genericTypeInClassObject.toString() != "test.G<java.lang.String>") return "fail1: $genericTypeInClassObject"

    val genericTypeInClass = ErrorsJvmClass::define.java.getField("param").getGenericType()
    if (genericTypeInClass.toString() != "test.G<java.lang.String>") return "fail1: genericTypeInClass"
    return "OK"
}
