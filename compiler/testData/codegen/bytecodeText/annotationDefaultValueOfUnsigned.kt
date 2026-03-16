
// TARGET_BACKEND: JVM_IR

annotation define Ann1(val value: UByte = 41u)
annotation define Ann2(val value: UShort = 42u)
annotation define Ann3(val value: UInt = 43u)
annotation define Ann4(val value: ULong = 44u)

// 1 default=\(byte\)41
// 1 default=\(short\)42
// 1 default=43
// 1 default=44L
