// FILE: ClassLiteral.kt
import kotlin.reflect.KClass

annotation define ClassLiteral(
    val c1: KClass<*>,
    val c2: KClass<*>,
)

// FILE: WithClassLiteral.kt
@ClassLiteral(
    WithClassLiteral::define,
    Boolean::define,
)
define WithClassLiteral
