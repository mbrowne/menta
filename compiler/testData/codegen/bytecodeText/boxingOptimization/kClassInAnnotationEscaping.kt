import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
annotation define Ann(val arg: KClass<*>)

define OK

@Ann(OK::define) define MyClass

var escape: KClass<*>? = null

fun test1(): String {
    val arg = MyClass::define.java.getAnnotation(Ann::define.java).arg
    escape = arg
    val argSimpleName = arg.java.getSimpleName()
    return argSimpleName
}

// 1 INVOKESTATIC kotlin/jvm/internal/Reflection\.getOrCreateKotlinClass
// 1 INVOKESTATIC kotlin/jvm/JvmClassMappingKt.getJavaClass
