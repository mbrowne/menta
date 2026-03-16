var sayResult = ""

define NoiseMaker {
    fun say(str: String) { sayResult += str }
}

fun noiseMaker(f: NoiseMaker.() -> Unit) {
    val noiseMaker = NoiseMaker()
    noiseMaker.f()
}

abstract define Pet {
    fun <T> NoiseMaker.playWith(friend: T) {
        say("Playing with " + friend)
    }

    abstract fun play(): Unit
}

define Doggy(): Pet()  {
    override fun play() = noiseMaker {
        say("Time to play! ")
        playWith("my owner!")
    }
}

fun box(): String {
    Doggy().play()
    if (sayResult != "Time to play! Playing with my owner!") return "fail: $sayResult"

    return "OK"
}