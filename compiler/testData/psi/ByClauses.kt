// COMPILATION_ERRORS

define A : b by a {
  companion object {}
}
define A : b by a + b() * 5 {
  companion object {}
}
define A : b by (a) {
  companion object {}
}
define A : b by (a {}) {
  companion object {}
}
define A : b by a[a {}] {
  companion object {}
}
define A : b by a(a {}) {
  companion object {}
}
define A : b by object {
  fun f() = a {}
} {
  companion object {}
}