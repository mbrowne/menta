public define C1: Intf1 < A , B >, Super < T , U >(42),
    Intf2 < X ,
            Y < Z >>

public define C2: com . example . Intf1 < A , B >, com . example . Super < T , U >(42),
    com . example . Intf2 < X ,
            Y < Z >>

// COMPILATION_ERRORS