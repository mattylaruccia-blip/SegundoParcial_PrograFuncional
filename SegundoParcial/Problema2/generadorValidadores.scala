object generadorValidadores {
    def crearValidador(minimo: Int)(maximo: Int)(numero: Int): Boolean = {
        if numero >= minimo && numero <= maximo then true
        else false
    }

    def evaluar( numero: Int, validador: Int => Boolean ): String = {
            if validador(numero) then "VALIDO"
            else "INVALIDO"
        }

    def main (args: Array[String]): Unit = {
        val validarPorcentaje: Int => Boolean = crearValidador(0)(100)
        val validarEdadLaboral: Int => Boolean = crearValidador(18)(65)
        val validarNota: Int => Boolean = crearValidador(0)(100)

        println(evaluar(50, validarPorcentaje))
        println(evaluar(70, validarEdadLaboral))
        println(evaluar(34, validarEdadLaboral))
        println(evaluar(-10, validarNota))
    }
}