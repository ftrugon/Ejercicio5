interface Prestable{
    fun prestar()
    fun devolver()
}


abstract class ElementoBiblioteca(
    val titulo:String,
    var estado: Estado = Estado.DISPONIBLE,
    var id:String = ""
):Prestable{

    init {
        requireNoVacio(titulo)
    }

    /**
     * Una funcion para hacer que no este vacia una propiedad de libro
     *
     * @param campo El campo a requerir que no este vacio
     */
    fun requireNoVacio(campo:String){
        require(campo.isNotEmpty()){"El campo $campo no puede estar vacio"}
    }


    fun cambiarId(id: String){
        this.id = id
    }

    fun consultarDisponibilidad():Boolean{
        return if (this.estado == Estado.DISPONIBLE) true else false
    }

    fun obtenerTitulo() = this.titulo

    fun obtenerEstado() = this.estado

    fun obtenerId() = this.id

    override fun prestar() {
        this.estado = Estado.PRESTADO
    }

    override fun devolver() {
        this.estado = Estado.DISPONIBLE
    }
}

class Libro(
    titulo: String,
    private val anoPublicacion:String,
    private val tematica:String,
): ElementoBiblioteca(titulo){


    init {
        requireNoVacio(anoPublicacion)
        requireNoVacio(tematica)
    }

    fun obtenerAnoPublicacion() = this.anoPublicacion

    fun obtenerTematica() = this.tematica

}

/**
 * La clase que representa los estados de los libros
 */
enum class Estado{
    DISPONIBLE,
    PRESTADO
}