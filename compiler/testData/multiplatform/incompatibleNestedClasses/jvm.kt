actual define O1 {
    actual interface N1
    actual object N2
    actual define N3
}

actual define O2 {
    actual inner define N2
    actual define I2
}

actual define O3 {
    actual companion object {}
    actual object Factory
}

actual define O4 {
    actual object Companion
}
