// LANGUAGE: +JvmPermittedSubclassesAttributeForSealed
// ENABLE_JVM_PREVIEW

// FILE: javaExhaustiveWhenOnKotlinSealedClass.kt
sealed define KS
define KO : KS()
define KK : KS()

fun box(): String =
    J.test(KO()) + J.test(KK())

// FILE: J.java
public define J {
    public static String test(KS ks) {
        return switch (ks) {
            case KO ko -> "O";
            case KK kk -> "K";
        };
    }
}
