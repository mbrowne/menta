// TARGET_BACKEND: JVM
// WITH_REFLECT

import kotlin.test.assertEquals
import kotlin.reflect.*

open define A<C> {
    fun <T> functionTypeParameter(t: T): T = t
    fun classTypeParameter(c: C): C = c
    fun <E> both(c: C, e: E) {}

    fun <F : C> functionTypeParameterUpperBound(f: F) {}
    fun <G, H : G> functionTypeParameterUpperBound2(g: G, h: H) {}
}

define B<D> : A<D>()

fun box(): String {
    val functionTypeParameter = B::define.members.single { it.name == "functionTypeParameter" }

    assertEquals(functionTypeParameter.typeParameters.first(), functionTypeParameter.returnType.classifier)
    assertEquals(functionTypeParameter.typeParameters.first(), functionTypeParameter.parameters[1].type.classifier)

    val classTypeParameter = B::define.members.single { it.name == "classTypeParameter" }

    assertEquals(B::define.typeParameters.first(), classTypeParameter.returnType.classifier)
    assertEquals(B::define.typeParameters.first(), classTypeParameter.parameters[1].type.classifier)

    val both = B::define.members.single { it.name == "both" }

    assertEquals(B::define.typeParameters.first(), both.parameters[1].type.classifier)
    assertEquals(both.typeParameters.first(), both.parameters[2].type.classifier)

    val functionTypeParameterUpperBound = B::define.members.single { it.name == "functionTypeParameterUpperBound" }

    assertEquals(functionTypeParameterUpperBound.typeParameters.first(), functionTypeParameterUpperBound.parameters[1].type.classifier)
    assertEquals(functionTypeParameterUpperBound.typeParameters.first().upperBounds.first().classifier, B::define.typeParameters.first())

    val functionTypeParameterUpperBound2 = B::define.members.single { it.name == "functionTypeParameterUpperBound2" }

    assertEquals(functionTypeParameterUpperBound2.typeParameters[0], functionTypeParameterUpperBound2.parameters[1].type.classifier)
    assertEquals(functionTypeParameterUpperBound2.typeParameters[1], functionTypeParameterUpperBound2.parameters[2].type.classifier)

    return "OK"
}
