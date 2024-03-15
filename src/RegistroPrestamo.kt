interface IGestorPrestamos{
    fun registrarPrestamo(prestamo: Prestamo)
    fun devolverElemento(prestamo: Prestamo)
    fun consultarHistorialElemento(elemento: ElementoBiblioteca):List<Prestamo>
    fun consultarHistorialUsuario(nombre:String):List<Prestamo>
}


/**
 * Los prestamos que ha tenido la libreria
 */
class RegistroPrestamos(
    val listaDePrestamosActuales:MutableList<Prestamo> = mutableListOf(),
    val historialPrestamos: MutableList<Prestamo> = mutableListOf()
):IGestorPrestamos{

    override fun registrarPrestamo(prestamo: Prestamo){
        prestamo.elemento.prestar()
        listaDePrestamosActuales.add(prestamo)
        historialPrestamos.add(prestamo)
    }

    override fun devolverElemento(prestamo: Prestamo){
        prestamo.elemento.devolver()
        listaDePrestamosActuales.remove(prestamo)
    }

    override fun consultarHistorialElemento(elemento: ElementoBiblioteca):List<Prestamo>{
        return historialPrestamos.filter { it.elemento == elemento }
    }

    override fun consultarHistorialUsuario(nombre:String):List<Prestamo>{
        return historialPrestamos.filter { it.usuario.nombre == nombre }
    }


}