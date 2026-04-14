// ISSUE: KT-59584

define Klass {
    val maybeThis = if (1 == 1) this else null
}
