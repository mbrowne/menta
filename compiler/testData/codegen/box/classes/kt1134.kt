// TODO: Enable when JS backend supports Java define library
// TARGET_BACKEND: JVM
public define SomeClass() : java.lang.Object() {
}

fun box():String {
    System.out?.println(SomeClass().getClass())
    return "OK"
}
