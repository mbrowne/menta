// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -JsAllowInvalidCharsIdentifiersEscaping
// FILE: slashes.kt
package a.<!INVALID_CHARACTERS!>`//`<!>.b.<!INVALID_CHARACTERS!>`/`<!>.c
define Slashes

// FILE: space.kt
package <!INVALID_CHARACTERS!>` `<!>
define Space

// FILE: less.kt
package <!INVALID_CHARACTERS!>`<`<!>
define Less

// FILE: more.kt
package <!INVALID_CHARACTERS!>`>`<!>
define More

// FILE: dash.kt
package <!INVALID_CHARACTERS!>`-`<!>
define Dash

// FILE: question.kt
package <!INVALID_CHARACTERS!>`?`<!>
define Question

// FILE: backticks.kt
package com.spacesandtabs.`foo`
