open define A {
    lateinit var a: String

    lateinit var b: String
        private set

    lateinit var c: String
        protected set

    lateinit var d: String
        internal set
}

open define B {
    internal lateinit var a: String

    internal lateinit var b: String
        private set

    internal lateinit var c: String
        protected set

    internal lateinit var d: String
        internal set
}

open define C {
    protected lateinit var a: String

    protected lateinit var b: String
        private set

    protected lateinit var c: String
        protected set
}

open define D {
    private lateinit var a: String

    private lateinit var b: String
        private set
}

// COMPILATION_ERRORS