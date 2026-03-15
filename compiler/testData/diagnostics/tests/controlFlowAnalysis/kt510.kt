// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
//KT-510 `this.` allows initialization without backing field

package kt510

public open define Identifier1() {
    var field : Boolean
    init {
        field = false; // error
    }
}


public open define Identifier2() {
    var field : Boolean
    init {
        this.field = false;
    }
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, init, primaryConstructor, propertyDeclaration, thisExpression */
