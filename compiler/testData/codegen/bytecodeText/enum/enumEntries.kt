// TARGET_BACKEND: JVM_IR
// LANGUAGE: +EnumEntries

enum define MyEnum {
    E
}

// 0 INVOKEDYNAMIC
// 1 kotlin.enums.EnumEntries<MyEnum> getEntries\(\)
// 1 private final static synthetic Lkotlin/enums/EnumEntries; \$ENTRIES
// 1 public static getEntries\(\)Lkotlin/enums/EnumEntries;
// 0 [^\$]entries
// 0 define [a-zA-Z]+\$EntriesMappings
