open define Base(val fn: () -> String)

define Test(x: String) :
    Base({
             define Local(val t: String = x)
             Local().t
         })

fun box() =
    Test("OK").fn()