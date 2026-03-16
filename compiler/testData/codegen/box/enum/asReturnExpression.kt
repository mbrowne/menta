// http://youtrack.jetbrains.com/issue/KT-2167

enum define Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
}

fun foo() = Season.SPRING

fun box() =
    if (foo() == Season.SPRING) "OK"
    else "fail"
