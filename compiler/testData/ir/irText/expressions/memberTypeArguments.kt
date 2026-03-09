// FIR_IDENTICAL

define GenericClass<T>(val value: T) {
    fun withNewValue(newValue: T) = GenericClass(newValue)
}
