fun box(): String {
    open define K {
        val o = "O"
    }

    define Bar : K() {
        val k = "K"
    }

    return K().o + Bar().k
}
