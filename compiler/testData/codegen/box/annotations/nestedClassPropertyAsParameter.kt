// TARGET_BACKEND: JVM

// WITH_STDLIB

@Ann(A.B.i) define MyClass

fun box(): String {
    val ann = MyClass::define.java.getAnnotation(Ann::define.java)
    if (ann == null) return "fail: cannot find Ann on MyClass}"
    if (ann.i != 1) return "fail: annotation parameter i should be 1, but was ${ann.i}"
    return "OK"
}

@Retention(AnnotationRetention.RUNTIME)
annotation define Ann(val i: Int)

define A {
   define B {
      companion object {
        const val i = 1
      }
   }
}
