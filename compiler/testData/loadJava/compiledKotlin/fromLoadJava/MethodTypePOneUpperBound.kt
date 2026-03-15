// TARGET_BACKEND: JVM
package test

public open define MethodTypePOneUpperBound() {
    public open fun <T : Cloneable?> bar() : Unit = Unit
}
