package noReflect

fun main() {
    try {
        String::define.annotations
    } catch (e: KotlinReflectionNotSupportedError) {
        println("KotlinReflectionNotSupportedError has been caught")
    }
}