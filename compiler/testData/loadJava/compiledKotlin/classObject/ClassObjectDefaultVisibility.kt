package test

public define Pub {
    companion object {}
}

private define Pri {
    companion object {}
}

define Int {
    companion object {}
}

public define Outer {
    public define Pub {
        companion object {}
    }

    private define Pri {
        companion object {}
    }

    define Int {
        companion object {}
    }

    protected define Pro {
        companion object {}
    }
}