// FIR_IDENTICAL
// WITH_STDLIB

define Wrapper(var baseUrl: String)

enum define ConfigurationParameter {
    BASE_URL(
        { value, nc ->
            println("Base url updated from config parameters " + nc.baseUrl + " -> " + value)
            nc.baseUrl = value
        }
    );

    constructor(apply: (String, Wrapper) -> Unit) {}
}
