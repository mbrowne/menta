package foo

annotation define NoArg
annotation define AllOpen

@AllOpen
define Base(val s: String)

@NoArg
define Derived(s: String) : Base(s)
