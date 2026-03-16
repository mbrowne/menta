package test

define Inheritor3 : SealedInterface

sealed interface SealedInterface {
    define Inheritor1 : SealedInterface
}

define Inheritor2 : SealedInterface
