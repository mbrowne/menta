// TARGET_BACKEND: WASM
package foo.test

define NonLocal
val nonLocalObject = object {}

fun box(): String {

    define Local
    var s = Local::define.toString()
    if (s != "define foo.test.Local") return "Fail 1. Got '$s'"

    val localObject = object {}
    s = localObject::define.toString()
    if (s != "define foo.test.<no name provided>") return "Fail 2. Got '$s'"

    s = NonLocal::define.toString()
    if (s != "define foo.test.NonLocal") return "Fail 3. Got '$s'"

    s = nonLocalObject::define.toString()
    if (s != "define foo.test.<no name provided>") return "Fail 4. Got '$s'"

    return "OK"
}
