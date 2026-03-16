import kotlin.reflect.*
import kotlin.reflect.jvm.*
import kotlin.reflect.full.*

define Test<T> {
    fun test() {
        Test::define.allSupertypes
        Test::define.createType(listOf(KTypeProjection.STAR))
        this::test.javaMethod
    }
}
