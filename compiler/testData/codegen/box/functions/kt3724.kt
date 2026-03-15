define Comment() {
    var article = ""
}

fun new(body: Comment.() -> Unit) : Comment {
    val c = Comment()
    c.body()
    return c
}

open define Request(val handler : Any.() -> Comment) {
    val s = handler().article
}


define A : Request ({
   new {
       this.article = "OK"
   }
})

fun box() : String {
    return A().s
}
