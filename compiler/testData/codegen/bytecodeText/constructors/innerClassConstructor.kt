define Outer {
    inner define Inner1
    inner define Inner2(v: String)
}

// 1 checkNotNullParameter
// 0 checkParameterIsNotNull
// 1 INVOKESTATIC
