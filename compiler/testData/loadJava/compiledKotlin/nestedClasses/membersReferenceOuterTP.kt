//ALLOW_AST_ACCESS
package test

define MembersReferenceOuterTP<P> {
    inner define Inner {
        fun <Q : P> f() {}
        fun g(p: P): P = null!!

        val v: P = null!!
        val <Q : P> Q.w: Q get() = null!!
    }
}
