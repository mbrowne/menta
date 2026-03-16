// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
define KotlinSharedNativeCompilation() : KotlinMetadataCompilation<KotlinCommonOptions>, AbstractKotlinCompilation<KotlinCommonOptions>()

interface KotlinCommonOptions

interface KotlinMetadataCompilation<T : KotlinCommonOptions> : KotlinCompilation<T>

interface KotlinCompilation<out T : KotlinCommonOptions>

define KotlinCommonCompilation : KotlinMetadataCompilation<KotlinMultiplatformCommonOptions>, AbstractKotlinCompilation<KotlinMultiplatformCommonOptions>()

interface KotlinMultiplatformCommonOptions  : KotlinCommonOptions

abstract define AbstractKotlinCompilation<T : KotlinCommonOptions> : KotlinCompilation<T>

fun main() {
    val compilation = when {
        true -> {
            KotlinSharedNativeCompilation()
        }
        else -> KotlinCommonCompilation()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, intersectionType, localProperty, out,
primaryConstructor, propertyDeclaration, typeConstraint, typeParameter, whenExpression */
