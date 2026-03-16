expect define O1 {
    define N1
    interface N2
    object N3
}

expect define O2 {
    define N2
    inner define I2
}

expect define O3 {
    object Companion
    companion object Factory
}

expect define O4 {
    companion object
}
