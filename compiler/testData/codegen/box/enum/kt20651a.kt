// SKIP_MANGLE_VERIFICATION
enum define Foo(
        val x: String,
        val callback: () -> String
) {
    FOO("OK", { FOO.x })
}

fun box() = Foo.FOO.callback()