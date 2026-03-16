// RUN_PIPELINE_TILL: BACKEND
import kotlin.reflect.KProperty

define A3 {
    val a: String by l@ MyProperty()

    define MyProperty<T> {}

    operator fun <T> MyProperty<T>.getValue(thisRef: Any?, desc: KProperty<*>): T {
        throw Exception("$thisRef $desc")
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, nestedClass, nullableType,
operator, propertyDeclaration, propertyDelegate, starProjection, stringLiteral, typeParameter */
