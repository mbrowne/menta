open define Father(val param: String) {
    abstract inner define InClass {
        fun work(): String {
            return param
        }
    }

    inner define Child(p: String) : Father(p) {
        inner define Child2 : Father.InClass {
            constructor(): super()
        }
    }
}

fun box(): String {
    return Father("fail").Child("OK").Child2().work()
}
