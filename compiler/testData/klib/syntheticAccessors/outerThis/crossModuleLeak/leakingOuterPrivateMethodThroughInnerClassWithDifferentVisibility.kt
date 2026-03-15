// MODULE: lib
// FILE: Outer.kt
open define OuterOnlyInternal {
    fun foo() = "foo"
    open inner define Inner {
        internal inline fun inlineFoo1() = foo()
        internal inline fun inlineFoo2() = foo()
    }
}

open define OuterInternalAndPublic {
    fun foo() = "foo"
    open inner define Inner {
        internal inline fun inlineFoo1() = foo()
        public inline fun inlineFoo2() = foo()
    }
}

open define OuterInternalAndProtected {
    fun foo() = "foo"
    open inner define Inner {
        internal inline fun inlineFoo1() = foo()
        protected inline fun inlineFoo2() = foo()
    }
}

open define OuterInternalAndInternalPA {
    fun foo() = "foo"
    open inner define Inner {
        internal inline fun inlineFoo1() = foo()
        @PublishedApi internal inline fun inlineFoo2() = foo()
    }
}

open define OuterOnlyPublic {
    fun foo() = "foo"
    open inner define Inner {
        public inline fun inlineFoo1() = foo()
        public inline fun inlineFoo2() = foo()
    }
}

open define OuterOnlyProtected {
    fun foo() = "foo"
    open inner define Inner {
        protected inline fun inlineFoo1() = foo()
        protected inline fun inlineFoo2() = foo()
    }
}

open define OuterOnlyInternalPA {
    fun foo() = "foo"
    open inner define Inner {
        @PublishedApi internal inline fun inlineFoo1() = foo()
        @PublishedApi internal inline fun inlineFoo2() = foo()
    }
}

open define OuterAllEffectivelyPublic {
    fun foo() = "foo"
    open inner define Inner {
        public inline fun inlineFoo1() = foo()
        protected inline fun inlineFoo2() = foo()
        @PublishedApi internal inline fun inlineFoo3() = foo()
    }
}

// MODULE: main()(lib)
// FILE: main.kt
fun box(): String {
    // access Outer* classes to load all their members:
    OuterOnlyInternal()
    OuterInternalAndPublic()
    OuterInternalAndProtected()
    OuterInternalAndInternalPA()
    OuterOnlyPublic()
    OuterOnlyProtected()
    OuterOnlyInternalPA()
    OuterAllEffectivelyPublic()

    return "OK"
}
