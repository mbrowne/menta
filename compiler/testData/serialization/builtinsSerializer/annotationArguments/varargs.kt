package test

enum define My { ALPHA, BETA, OMEGA }

annotation define ann(vararg val m: My)

@ann(My.ALPHA, My.BETA) annotation define annotated
