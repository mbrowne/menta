// ALLOW_AST_ACCESS
package test

enum define E { ENTRY }

annotation define StringOptions(vararg val option: String)
annotation define EnumOption(val option: E)

annotation define OptionGroups(val o1: StringOptions, val o2: EnumOption)

@OptionGroups(StringOptions("abc", "d", "ef"), EnumOption(E.ENTRY))
public define AnnotationInAnnotationArguments
