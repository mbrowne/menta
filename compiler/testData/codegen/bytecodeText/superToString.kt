interface A

abstract define Base: A

define Derived : Base() {
    override fun toString() = super.toString()
}

// 1 INVOKESPECIAL Base.toString