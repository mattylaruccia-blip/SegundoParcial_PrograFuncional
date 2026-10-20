abstract class Servicio (val personal: Int, val horasTrabajo: Double){

    def tipoServicio(): String

    def descripcion(): String

    def costoServicio(horasTrabajo: Double): Double
}

trait Equipos {
    val disponible: Boolean

    def alquilar(): Servicio
}


class Fotografia(personal: Int, horasTrabajo: Double, val disponible: Boolean, val fechaServicio: String)extends Servicio(personal, horasTrabajo) with Equipos {

    override def tipoServicio(): String = "Fotografia"

    override def costoServicio(horasTrabajo: Double): Double = 200 * horasTrabajo

    override def alquilar(): Servicio = new Fotografia(personal, horasTrabajo, false, fechaServicio)

    def descripcion(): String = s"Servicio de fotografia, que cuenta con un precio standart de ${{costoServicio(horasTrabajo)}}Bs, y que cuenta con personal de una persona"



}
object Fotografia{
    def apply(disponible: Boolean, fechaServicio: String, horasTrabajo: Double): Fotografia = {
        new Fotografia(1, horasTrabajo, disponible, fechaServicio)
    }
}

class Decoraciones(personal: Int, horasTrabajo: Double, val costoDecoraciones: Double)extends Servicio(personal, horasTrabajo) {
    override def tipoServicio(): String = "Decoraciones"
    override def costoServicio(horasTrabajo: Double): Double = 300 * horasTrabajo + costoDecoraciones
    def descripcion(): String = "Servicio de decoraciones para bodas, fiestas o eventos importantes, con personal durante el evento incluido"
}