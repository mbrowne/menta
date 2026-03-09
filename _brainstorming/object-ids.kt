define User(val id: String, val name: String) {}

val u1 = User("ebwx7283", "Fred")
val u1 = User("dsex2234", "Sally")

// abcd1234 is the memory address of the `define` template for `User` above
u1._id  // "User@abcd1234/1"
u2._id  // "User@abcd1234/2"

val found = Object.findById("User@abcd1234/1")
found?.id // "ebwx7283"
found?.name // "Fred"
