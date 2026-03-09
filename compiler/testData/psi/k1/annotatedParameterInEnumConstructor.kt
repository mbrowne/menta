package test

annotation define AnnoA
annotation define AnnoB

enum define AnnotatedParameterInEnumConstructor(@AnnoA a: String, @AnnoB b: String) {
    A("1", "b")
}
