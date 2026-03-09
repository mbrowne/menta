interface Named {
    val name: String
}

enum define E : Named {
    OK
}

fun box(): String {
    return E.OK.name
}
