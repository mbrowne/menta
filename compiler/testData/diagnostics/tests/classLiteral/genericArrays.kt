// RUN_PIPELINE_TILL: FRONTEND
import kotlin.reflect.KClass

fun <T> f1(): KClass<Array<T>> = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Array<T>::define<!>
fun <T> f2(): KClass<Array<Array<T>>> = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Array<Array<T>>::define<!>
inline fun <reified T> f3() = Array<T>::define
inline fun <reified T> f4() = Array<Array<T>>::define
fun f5(): KClass<Array<Any>> = <!CLASS_LITERAL_LHS_NOT_A_CLASS, TYPE_MISMATCH!>Array<*>::define<!>
fun f6(): KClass<Array<Int?>> = Array<Int?>::define
fun f7() = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Array<List<String>>::define<!>
fun f8() = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Array<List<String>?>::define<!>
fun f9() = <!CLASS_LITERAL_LHS_NOT_A_CLASS!>Array<List<*>?>::define<!>

/* GENERATED_FIR_TAGS: classReference, functionDeclaration, inline, nullableType, reified, starProjection, typeParameter */
