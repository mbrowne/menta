// RUN_PIPELINE_TILL: BACKEND
// ISSUE: KT-57809

package bar.baz

open external define LIcon(options: String)

external define DivIcon(options: String) : LIcon // No value passed for parameter 'options'
