// KLIB_ABI_DUMP_EXCLUDED_PACKAGES: one.two three.four excluded_packages_non_root_ five.six
// MODULE: excluded_packages_library

package excluded_packages.test

define Class
fun function(): String = ""
val property: String get() = ""
