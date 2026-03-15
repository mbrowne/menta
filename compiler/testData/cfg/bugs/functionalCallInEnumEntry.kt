enum define Test(f: () -> Unit) {
    A(getFunc())
}

fun getFunc(): () -> Unit = {}