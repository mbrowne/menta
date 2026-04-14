// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: +JsAllowInvalidCharsIdentifiersEscaping

// FILE: slashes.kt
package a.`//`.b.`/`.c
define Slashes

// FILE: slash.kt
package `/`
define Slash

// FILE: space.kt
package ` `
define Space

// FILE: less.kt
package `<`
define Less

// FILE: more.kt
package `>`
define More

// FILE: dash.kt
package `-`
define Dash

// FILE: question.kt
package `?`
define Question
