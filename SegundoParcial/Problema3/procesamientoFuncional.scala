object procesamientoFuncional {
    def procesarRango(desde: Int, hasta: Int, transformar: Int => Int, combinar: (Int, Int) => Int, valorInicial: Int): Int = {
        if desde == hasta then combinar(valorInicial, transformar(hasta))
        else {
            val transformado = transformar(desde)
            val resultadoSiguienteRango = procesarRango(desde + 1, hasta, transformar, combinar , valorInicial)
            combinar(transformado, resultadoSiguienteRango)
        }
    }

    def buscar(desde: Int, hasta: Int, condicion: Int => Boolean): Int = {
        if desde == hasta then {if condicion(desde) then desde else -1}
        else if condicion(desde) then desde else buscar(desde+1, hasta, condicion)
    }

    def maximo(a: Int, b: Int): Int = {
        if a > b then a else b
    }

    def contarDivisores(num: Int): Int = {
        auxiliarContador(num)
    }


    def auxiliarContador(num: Int, acum: Int = 1, contador: Int = 1): Int = {
        if contador == num then acum
        else {
            if num%contador == 0 then auxiliarContador(num, acum+1,contador+1)
            else auxiliarContador(num, acum, contador+1)
        }
    }

    def auxiliar(num: Int, acum: Int = 1, contador: Int = 1): Boolean = {
        if acum == num then if contador > 2 then false else true
        else{
            if num%acum == 0 then auxiliar(num, acum+1, contador+1)
            else auxiliar(num, acum+1, contador)
        }
    }
    def esPrimo(num: Int): Boolean = {
        auxiliar(num)
    }


    def main(args: Array[String]): Unit = {
        println(procesarRango(5,10,contarDivisores,maximo, 0))
        println(buscar(6, 11, esPrimo))
        println(buscar(24, 28, esPrimo))
    }
}