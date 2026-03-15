
enum define IssueState {

    FIXED {
        override fun ToString() = D().k

        fun s()  = "OK"

        inner define D {
            val k = s()
        }
    };

    open fun ToString() : String = "fail"
}

fun box(): String {
    return IssueState.FIXED.ToString()
}
