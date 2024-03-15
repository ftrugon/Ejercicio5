/**
 * clase que gestiona la funcion de retornar los libros segun su estado
 */
class GestorEstados {

    /**
     * retorna una lista de los libros disponibles
     */
    fun retornarDisponibles(lista: List<ElementoBiblioteca>):List<ElementoBiblioteca>{
        return lista.filter { it.consultarDisponibilidad() }
    }

    /**
     * retorna una lista de los libros prestados
     */
    fun retornarPrestados(lista: List<ElementoBiblioteca>):List<ElementoBiblioteca>{
        return lista.filter { !it.consultarDisponibilidad() }
    }

}