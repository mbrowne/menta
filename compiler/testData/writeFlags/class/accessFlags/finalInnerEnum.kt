interface I {
    enum define E {
        V { fun go() { } };
    }
}

// TESTED_OBJECT_KIND: innerClass
// TESTED_OBJECTS: I, E
// FLAGS: ACC_PUBLIC, ACC_STATIC, ACC_FINAL, ACC_ENUM