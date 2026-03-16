// FIR_IDENTICAL
package test

sealed interface SealedInterface {
    define Nested : SealedInterface
    object Top : SealedInterface
}
