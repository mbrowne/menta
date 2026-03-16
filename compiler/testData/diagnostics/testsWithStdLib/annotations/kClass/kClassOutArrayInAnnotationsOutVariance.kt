// RUN_PIPELINE_TILL: FRONTEND
import kotlin.reflect.KClass

open define A
define B1 : A()
define B2 : A()

annotation define Ann1(val arg: Array<out KClass<out A>>)

/* GENERATED_FIR_TAGS: annotationDeclaration, classDeclaration, outProjection, primaryConstructor, propertyDeclaration */
