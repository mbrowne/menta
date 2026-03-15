open define ATChar<T : Char>(open var x: T)

open define BTChar<T : Char>(override var x: T) : ATChar<T>(x)

define CChar(override var x: Char) : BTChar<Char>('x')
