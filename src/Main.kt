fun main() {

    //creacion de usuarios

    val listaUsuarios = listOf(
        Usuario("fran") ,
        Usuario("Ivan"),
        Usuario("Nico"),
        Usuario("Tocayo")
    )

    //Creacion del gestor
    val gestor = GestorBiblioteca(Catalogo(),RegistroPrestamos(), UtilidadesBiblioteca(), GestorEstados(),listaUsuarios)

    //Creacion de los libros
    val libro1 = Libro("hola","2020","aventura")
    val libro2 = Libro("que","2020","aventura")
    val libro3 = Libro("tal","2020","aventura")
    val libro4 = Libro("cual","2020","aventura")
    val libro5 = Libro("hermano","2020","aventura")
    val libro6 = Libro("hola","2020","aventura")

    // Agregando los libros
    gestor.agregarAlCatalogo(libro1)
    gestor.agregarAlCatalogo(libro2)
    gestor.agregarAlCatalogo(libro3)
    gestor.agregarAlCatalogo(libro4)
    gestor.agregarAlCatalogo(libro5)
    gestor.agregarAlCatalogo(libro6)

    // Registrando los prestamos
    gestor.registrarPrestamo(libro1,"fran")
    gestor.registrarPrestamo(libro2,"fran")

    gestor.registrarPrestamo(libro3,"Ivan")
    gestor.registrarPrestamo(libro4,"Ivan")

    gestor.registrarPrestamo(libro5,"Nico")
    gestor.registrarPrestamo(libro6,"Nico")


    // Devolviendo los libros
    gestor.devolverLibro(libro1,"fran")
    gestor.devolverLibro(libro2,"fran")

    gestor.devolverLibro(libro3,"Ivan")
    gestor.devolverLibro(libro4,"Ivan")

    gestor.devolverLibro(libro5,"Nico")
    gestor.devolverLibro(libro6,"Nico")

    // Prestando otro libro para ver si el historial es correcto

    gestor.registrarPrestamo(libro1,"fran")

    val gestorConsola = GestorConsola()

    // Printeando los estados de los libros
    println("*** TODOS ***")
    val todos = gestor.retornarTodos()
    gestorConsola.mostrarEstadoLibro(todos)

    println("\n*** PRESTADOS ***")
    val prestados = gestor.retornarPrestados()
    gestorConsola.mostrarEstadoLibro(prestados)

    println("\n*** DISPONIBLES ***")
    val disponibles = gestor.retornarDisponibles()
    gestorConsola.mostrarEstadoLibro(disponibles)


    println("\n*** HISTORIALES DE LIBROS***")

    val historialLibro1 = gestor.consultarHistorialLibro(libro1)
    gestorConsola.mostrarHistorialLibro(historialLibro1)

    val historialLibro2 = gestor.consultarHistorialLibro(libro2)
    gestorConsola.mostrarHistorialLibro(historialLibro2)

    val historialLibro3 = gestor.consultarHistorialLibro(libro3)
    gestorConsola.mostrarHistorialLibro(historialLibro3)

    val historialLibro4 = gestor.consultarHistorialLibro(libro4)
    gestorConsola.mostrarHistorialLibro(historialLibro4)


    println("\n*** HISTORIALES DE PERSONAS***")
    val historialFran = gestor.consultarHistorialUsuario("fran")
    gestorConsola.mostrarHistorialPersona(historialFran)

    val historialIvan= gestor.consultarHistorialUsuario("Ivan")
    gestorConsola.mostrarHistorialPersona(historialIvan)
}