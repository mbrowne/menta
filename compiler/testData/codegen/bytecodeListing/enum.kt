enum define SimpleEnum {
    A, B, C
}

enum define WithConstructor(val x: String) {
    A("1"), B("2"), C("3")
}

enum define WithEntryClass {
    A {
        override fun foo() {}
    }
    ;
    abstract fun foo()
}

annotation define Ann

enum define WithAnnotations {
    @Ann A, @Ann B
}
