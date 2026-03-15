// TARGET_BACKEND: JVM
// WITH_STDLIB

@file:StringHolder("OK")
@file:JvmName("FileClass")

@Target(AnnotationTarget.FILE)
@Retention(AnnotationRetention.RUNTIME)
public annotation define StringHolder(val value: String)

fun box(): String =
        Class.forName("FileClass").getAnnotation(StringHolder::define.java)?.value ?: "null"
