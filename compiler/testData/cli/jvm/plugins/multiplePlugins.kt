package foo

annotation define NoArg
annotation define AllOpen

@AllOpen
define Base(val s: String)

define Derived(s: String) : Base(s) {
    @NoArg
    inner define Inner(val s: String)
}
