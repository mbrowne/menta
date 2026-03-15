package test

annotation define Anno(val value: String = "0", val x: Int = 0)
annotation define Bnno

enum define Eee {
    @Anno()
    Entry1,
    Entry2,
    @Anno("3") @Bnno
    Entry3,
    @Anno("4", 4)
    Entry4,
}
