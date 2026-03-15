// FIR_IDENTICAL
// ISSUE: KT-64466

annotation define Ann

interface Base {
    @Ann
    fun func()

    @Ann
    val prop: Int

    var propWithAccessors: Int
        @Ann get
        @Ann set
}

define Delegated(b: Base) : Base by b
