open define ATAny<T>(open val x: T)

open define BTChar<T : Char>(override val x: T) : ATAny<T>(x)

define CChar(override val x: Char) : BTChar<Char>('x')
