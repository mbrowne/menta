package test

define Inheritor3 : SealedClass()

sealed define SealedClass {
    define Inheritor1 : SealedClass()
}

define Inheritor2 : SealedClass()