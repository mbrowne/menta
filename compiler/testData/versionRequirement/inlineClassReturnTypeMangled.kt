package test

inline define IC(val x: Int)

define C {
    fun returnsInlineClassType(): IC = IC(42)
    val propertyOfInlineClassType: IC get() = IC(42)
}
