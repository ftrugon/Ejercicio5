/**
 * El gestor de ela biblioteca
 *
 * @property catalogo el catalogo con todos los libros de la biblioteca
 * @property registroPrestamos registro de los prestamos que ha habido
 * @property utilidadesBiblioteca utilidades pequeñas y especificas de la biblioteca
 */
class GestorBiblioteca(
    val catalogo: GestorElementos<ElementoBiblioteca>,
    val registroPrestamos: IGestorPrestamos,
    val utilidadesBiblioteca: UtilidadesBiblioteca,
    val gestorEstados: GestorEstados,
    val usuarios:List<Usuario>) {

    /**
     * Añade un libro al catalogo
     */
    fun agregarAlCatalogo(elemento: ElementoBiblioteca){
        elemento.cambiarId(utilidadesBiblioteca.generarIdentificadorUnico())
        catalogo.agregarAlCatalogo(elemento)
    }

    /**
     * Elimina un libro del catalogo
     */
    fun eliminarDelCatalogo(elemento: ElementoBiblioteca) = catalogo.eliminarDelCatalogo(elemento)


    /**
     * Registra un prestamo
     */
    fun registrarPrestamo(libro: Libro,nombreUsuario: String){

        val usuarioaPrestarle = usuarios.find { it.nombre == nombreUsuario }
        val libroaPrestar = catalogo.listaDeElementos.find {  it == libro  }

        if (libroaPrestar != null && usuarioaPrestarle != null && libro.consultarDisponibilidad()){


            val prestamo = Prestamo(libroaPrestar,usuarioaPrestarle)

            registroPrestamos.registrarPrestamo(prestamo)
            usuarioaPrestarle.agregaraListaPrestamos(prestamo)

        }
    }

    /**
     * devuelve el estado de un libro a disponible
     */
    fun devolverLibro(elemento: ElementoBiblioteca,nombreUsuario: String){

        val usuarioaDevolver = usuarios.find { it.nombre == nombreUsuario }
        val elementoaDevolver = catalogo.listaDeElementos.find {  it == elemento  }

        if (elementoaDevolver != null && usuarioaDevolver != null){

            val prestamo = Prestamo(elementoaDevolver,usuarioaDevolver)

            registroPrestamos.devolverElemento(prestamo)
            usuarioaDevolver.eliminardeListaPrestamos(prestamo)
        }

    }


    // HE QUITADO LA FUNCION QUE RETORNABA CADA LIBRO CON SU ESTADO Y LA HE DIVIDO EN TRES Y UNA CLASE
    fun retornarTodos() = catalogo.listaDeElementos

    fun retornarPrestados() = gestorEstados.retornarPrestados(catalogo.listaDeElementos)

    fun retornarDisponibles() = gestorEstados.retornarDisponibles(catalogo.listaDeElementos)

    fun consultarHistorialLibro(libro: Libro) = registroPrestamos.consultarHistorialElemento(libro)

    fun consultarHistorialUsuario(nombre:String) = registroPrestamos.consultarHistorialUsuario(nombre)

}

