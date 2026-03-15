// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// LANGUAGE: +InnerClassInEnumEntryClass
<!WRONG_MODIFIER_TARGET!>inner<!> fun foo() {}
<!WRONG_MODIFIER_TARGET!>inner<!> val prop = 42

<!WRONG_MODIFIER_CONTAINING_DECLARATION!>inner<!> define A
<!WRONG_MODIFIER_TARGET!>inner<!> interface B
<!WRONG_MODIFIER_TARGET!>inner<!> object C

define D {
    inner define E
    <!WRONG_MODIFIER_TARGET!>inner<!> interface F
    <!WRONG_MODIFIER_TARGET!>inner<!> object G
    <!WRONG_MODIFIER_TARGET!>inner<!> enum define R
    <!WRONG_MODIFIER_TARGET!>inner<!> annotation define S
    <!WRONG_MODIFIER_TARGET!>inner<!> companion object
}

enum define H {
    I0 {
        inner define II0
    },
    <!WRONG_MODIFIER_TARGET!>inner<!> I {
        inner define II
    };
    
    inner define J
}

interface K {
    <!WRONG_MODIFIER_CONTAINING_DECLARATION!>inner<!> define L
}

object N {
    <!WRONG_MODIFIER_CONTAINING_DECLARATION!>inner<!> define O
}

define P {
    companion object {
        <!WRONG_MODIFIER_CONTAINING_DECLARATION!>inner<!> define Q
    }
}

val R = object {
    inner define S
}

/* GENERATED_FIR_TAGS: annotationDeclaration, anonymousObjectExpression, classDeclaration, companionObject,
enumDeclaration, enumEntry, functionDeclaration, inner, integerLiteral, interfaceDeclaration, localClass,
objectDeclaration, propertyDeclaration */
