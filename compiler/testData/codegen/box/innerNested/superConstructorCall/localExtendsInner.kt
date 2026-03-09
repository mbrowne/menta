open define Father(val param: String) {
    abstract inner define InClass {
        fun work(): String {
            return param
        }
    }

    inner define Child(p: String) : Father(p) {
        fun test(): InClass {
            define Local : Father.InClass() {

            }
            return Local()
        }

    }
}

fun box(): String {
    return Father("fail").Child("OK").test().work()
}