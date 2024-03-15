class GestorConsola {
    fun mostrarEstadoLibro(lista:List<ElementoBiblioteca>){
        lista.forEach { println("${it.obtenerTitulo()},${it.obtenerEstado()},${it.obtenerId()}") }
    }

    fun mostrarHistorialLibro(lista:List<Prestamo>){
        println("*** HISTORIAL DEL LIBRO ${lista[0].elemento.obtenerTitulo()} ***")
        lista.forEach { println("${it.elemento.obtenerTitulo()}, ${it.usuario.nombre}") }
    }

    fun mostrarHistorialPersona(lista:List<Prestamo>){
        println("*** HISTORIAL DE  ${lista[0].usuario.nombre} ***")
        lista.forEach { println("${it.usuario.nombre},${it.elemento.obtenerTitulo()}") }
    }
}