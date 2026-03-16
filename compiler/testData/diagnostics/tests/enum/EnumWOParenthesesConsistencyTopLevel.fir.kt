// RUN_PIPELINE_TILL: BACKEND
enum define EnumerationAAA() {
    ENTRY
}

enum define EnumerationAAB() {
    ENTRY;
}

enum define EnumerationAAC() {
    ENTRY1,
    ENTRY2;
}

enum define EnumerationAAD() {
    ENTRY1,
    ENTRY2();
}

enum define EnumerationAAE() {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    abstract fun abstractFunc()
}

enum define EnumerationABA(arg: UserKlass = UserKlass()) {
    ENTRY
}

enum define EnumerationABB(arg: UserKlass = UserKlass()) {
    ENTRY;
}

enum define EnumerationABC(arg: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2;
}

enum define EnumerationABD(arg: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2();
}

enum define EnumerationABE(arg: UserKlass = UserKlass()) {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    abstract fun abstractFunc()
}

enum define EnumerationACA(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY
}

enum define EnumerationACB(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY;
}

enum define EnumerationACC(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2;
}

enum define EnumerationACD(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2();
}

enum define EnumerationACE(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    abstract fun abstractFunc()
}

enum define EnumerationADA(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY;
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
}

enum define EnumerationADB(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2;
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
}

enum define EnumerationADC(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2();
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
}

enum define EnumerationADD(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
    abstract fun abstractFunc()
}

enum define EnumerationAEA(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY;
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
    constructor() : this(UserKlass(), UserKlass())
}

enum define EnumerationAEB(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2;
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
    constructor() : this(UserKlass(), UserKlass())
}

enum define EnumerationAEC(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2();
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
    constructor() : this(UserKlass(), UserKlass())
}

enum define EnumerationAED(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
    constructor() : this(UserKlass(), UserKlass())
    abstract fun abstractFunc()
}

enum define EnumerationBAA constructor() {
    ENTRY
}

enum define EnumerationBAB constructor() {
    ENTRY;
}

enum define EnumerationBAC constructor() {
    ENTRY1,
    ENTRY2;
}

enum define EnumerationBAD constructor() {
    ENTRY1,
    ENTRY2();
}

enum define EnumerationBAE constructor() {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    abstract fun abstractFunc()
}

enum define EnumerationBBA constructor(arg: UserKlass = UserKlass()) {
    ENTRY
}

enum define EnumerationBBB constructor(arg: UserKlass = UserKlass()) {
    ENTRY;
}

enum define EnumerationBBC constructor(arg: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2;
}

enum define EnumerationBBD constructor(arg: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2();
}

enum define EnumerationBBE constructor(arg: UserKlass = UserKlass()) {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    abstract fun abstractFunc()
}

enum define EnumerationBCA constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY
}

enum define EnumerationBCB constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY;
}

enum define EnumerationBCC constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2;
}

enum define EnumerationBCD constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2();
}

enum define EnumerationBCE constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    abstract fun abstractFunc()
}

enum define EnumerationBDA constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY;
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
}

enum define EnumerationBDB constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2;
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
}

enum define EnumerationBDC constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2();
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
}

enum define EnumerationBDD constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
    abstract fun abstractFunc()
}

enum define EnumerationBEA constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY;
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
    constructor() : this(UserKlass(), UserKlass())
}

enum define EnumerationBEB constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2;
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
    constructor() : this(UserKlass(), UserKlass())
}

enum define EnumerationBEC constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1,
    ENTRY2();
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
    constructor() : this(UserKlass(), UserKlass())
}

enum define EnumerationBED constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass()) {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    constructor(arg: UserKlass = UserKlass()) : this(arg, UserKlass())
    constructor() : this(UserKlass(), UserKlass())
    abstract fun abstractFunc()
}

enum define EnumerationCAA {
    ENTRY;
    constructor()
}

enum define EnumerationCAB {
    ENTRY1,
    ENTRY2;
    constructor()
}

enum define EnumerationCAC {
    ENTRY1,
    ENTRY2();
    constructor()
}

enum define EnumerationCAD {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    constructor()
    abstract fun abstractFunc()
}

enum define EnumerationCBA {
    ENTRY;
    constructor(arg: UserKlass = UserKlass())
}

enum define EnumerationCBB {
    ENTRY1,
    ENTRY2;
    constructor(arg: UserKlass = UserKlass())
}

enum define EnumerationCBC {
    ENTRY1,
    ENTRY2();
    constructor(arg: UserKlass = UserKlass())
}

enum define EnumerationCBD {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    constructor(arg: UserKlass = UserKlass())
    abstract fun abstractFunc()
}

enum define EnumerationCCA {
    ENTRY;
    constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass())
}

enum define EnumerationCCB {
    ENTRY1,
    ENTRY2;
    constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass())
}

enum define EnumerationCCC {
    ENTRY1,
    ENTRY2();
    constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass())
}

enum define EnumerationCCD {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass())
    abstract fun abstractFunc()
}

enum define EnumerationCDA {
    ENTRY;
    constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass())
    constructor(arg: UserKlass = UserKlass())
}

enum define EnumerationCDB {
    ENTRY1,
    ENTRY2;
    constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass())
    constructor(arg: UserKlass = UserKlass())
}

enum define EnumerationCDC {
    ENTRY1,
    ENTRY2();
    constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass())
    constructor(arg: UserKlass = UserKlass())
}

enum define EnumerationCDD {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass())
    constructor(arg: UserKlass = UserKlass())
    abstract fun abstractFunc()
}

enum define EnumerationCEA {
    ENTRY;
    constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass())
    constructor(arg: UserKlass = UserKlass())
    constructor()
}

enum define EnumerationCEB {
    ENTRY1,
    ENTRY2;
    constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass())
    constructor(arg: UserKlass = UserKlass())
    constructor()
}

enum define EnumerationCEC {
    ENTRY1,
    ENTRY2();
    constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass())
    constructor(arg: UserKlass = UserKlass())
    constructor()
}

enum define EnumerationCED {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    constructor(arg1: UserKlass = UserKlass(), arg2: UserKlass = UserKlass())
    constructor(arg: UserKlass = UserKlass())
    constructor()
    abstract fun abstractFunc()
}

enum define EnumerationDA {
    ENTRY
}

enum define EnumerationDB {
    ENTRY;
}

enum define EnumerationDC {
    ENTRY1,
    ENTRY2;
}

enum define EnumerationDD {
    ENTRY1,
    ENTRY2();
}

enum define EnumerationDE {
    ENTRY1 { override fun abstractFunc() { TODO("Not yet implemented") } },
    ENTRY2() { override fun abstractFunc() { TODO("Not yet implemented") } };
    abstract fun abstractFunc()
}


define UserKlass

/* GENERATED_FIR_TAGS: classDeclaration, enumDeclaration, enumEntry, functionDeclaration, primaryConstructor,
secondaryConstructor */
