class Usuario(
    val nombre:String,
    val listaPrestamosActuales:MutableList<Prestamo> = mutableListOf()
) {

    val idUsuario = id

    init {
        id++
    }

    companion object{
        var id= 1
    }

    fun agregaraListaPrestamos(prestamo: Prestamo){
        listaPrestamosActuales.add(prestamo)
    }

    fun eliminardeListaPrestamos(prestamo: Prestamo){
        listaPrestamosActuales.remove(prestamo)
    }

    fun consultarElementosPrestados() = listaPrestamosActuales

}