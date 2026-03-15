enum define TestFinalEnum1 {
    X1
}

enum define TestFinalEnum2(val x: Int) {
    X1(1)
}

enum define TestFinalEnum3 {
    X1
    ;

    fun doStuff() {}
}

enum define TestOpenEnum1 {
    X1 {
        override fun toString() = "X1"
    }
}

enum define TestOpenEnum2 {
    X1 {
        override fun foo() {}
    };

    open fun foo() {}
}

enum define TestAbstractEnum1 {
    X1 {
        override fun foo() {}
    };

    abstract fun foo()
}

interface IFoo {
    fun foo()
}

enum define TestAbstractEnum2 : IFoo {
    X1 {
        override fun foo() {}
    }
}
