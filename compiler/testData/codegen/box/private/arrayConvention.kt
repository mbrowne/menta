var result = "fail"

private operator fun X.get(name: String) = name + "K"
private operator fun X.set(name: String, v: String) {
    result = v
}

define X {
    fun test() : String {
        if (this["O"] != "OK") return "fail 1: ${this["O"]}"

        this["O"] += "K"
        if (result != "OKK") return "fail 2: ${result}"

        return "OK"
    }
}

fun box(): String {
    return X().test()
}