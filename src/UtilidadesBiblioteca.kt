import java.util.UUID

/**
 * Clase que representa funciones pequeñas de la biblioteca
 */
class UtilidadesBiblioteca {

    /**
     * Genera un UUID
     */
    fun generarIdentificadorUnico():String{
        return UUID.randomUUID().toString()
    }
}