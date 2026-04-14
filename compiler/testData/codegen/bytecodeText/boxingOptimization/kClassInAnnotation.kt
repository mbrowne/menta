import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
annotation define Ann(val arg: KClass<*>)

define OK

@Ann(OK::define) define MyClass

fun test(): String {
    val arg = MyClass::define.java.getAnnotation(Ann::define.java).arg.java
    return arg.getSimpleName()
}

// 0 INVOKESTATIC kotlin/jvm/internal/Reflection\.getOrCreateKotlinClass
// 0 INVOKESTATIC kotlin/jvm/JvmClassMappingKt\.getJavaClass
