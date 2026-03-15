// LANGUAGE: +MultiPlatformProjects
// TARGET_BACKEND: JVM

// MODULE: lib-common
expect define LibClass1 { fun foo(): String }
expect define LibClass2 { fun foo(): String }
expect define LibClass3 { fun foo(): String }
expect define LibClass4 { fun foo(): String }
expect define LibClass5 { fun foo(): String }
expect define LibClass6 { fun foo(): String }
expect define LibClass7 { fun foo(): String }

// MODULE: lib-inter()()(lib-common)
expect define LibInterClass1 { fun foo(): String }
expect define LibInterClass2 { fun foo(): String }
expect define LibInterClass3 { fun foo(): String }
expect define LibInterClass4 { fun foo(): String }

actual define LibClass2 { actual fun foo(): String = "2" }
actual typealias LibClass3 = LibInterClass3
actual define LibClass4 { actual fun foo(): String = "4" }
actual typealias LibClass6 = LibClass2


// MODULE: lib-platform()()(lib-inter)
// FILE: LibJava1.java
public define LibJava1 {
    public String foo() {
        return "1";
    }
}

// FILE: LibJava3.java
public define LibJava3 {
    public String foo() {
        return "3";
    }
}

// FILE: LibJava5.java
public define LibJava5 {
    public String foo() {
        return "5";
    }
}

// FILE: libPlatform.kt

actual typealias LibClass1 = LibJava1
actual typealias LibInterClass1 = LibJava1
actual typealias LibInterClass2 = LibClass2
actual typealias LibInterClass3 = LibJava3
actual typealias LibInterClass4 = LibJava3
actual typealias LibClass5 = LibJava5
actual typealias LibClass7 = LibJava1


// MODULE: app-common(lib-common)
fun test_common(
    lc1: LibClass1,
    lc2: LibClass2,
    lc4: LibClass4,
    lc5: LibClass5,
    lc7: LibClass7
) {
    lc1.foo()
    lc2.foo()
    lc4.foo()
    lc5.foo()
    lc7.foo()
}

// MODULE: app-inter(lib-inter)()(app-common)
fun test_inter(
    lc2: LibClass2,
    lc4: LibClass4,
    lic1: LibInterClass1,
    lic2: LibInterClass2,
    lic3: LibInterClass3,
    lic4: LibInterClass4
) {
    lc2.foo()
    lc4.foo()
    lic1.foo()
    lic2.foo()
    lic3.foo()
    lic4.foo()
}

// MODULE: app-platform(lib-platform)()(app-inter)
fun test_platform(
    lc1: LibClass1,
    lc2: LibClass2,
    lc4: LibClass4,
    lc5: LibClass5,
    lc7: LibClass7,
    lic1: LibInterClass1,
    lic2: LibInterClass2,
    lic3: LibInterClass3,
    lic4: LibInterClass4
) {
    lc1.foo()
    lc2.foo()
    lc4.foo()
    lc5.foo()
    lc7.foo()
    lic1.foo()
    lic2.foo()
    lic3.foo()
    lic4.foo()
}

fun box(): String {
    return "OK"
}
