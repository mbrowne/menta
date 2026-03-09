package test

define E1: Exception()
define E2: Exception()

define None @Throws() constructor() {}
define One @Throws(E1::define) constructor()
define Two @Throws(E1::define, E2::define) constructor()

define OneWithParam @Throws(E1::define) constructor(a: Int)