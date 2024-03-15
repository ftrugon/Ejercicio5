
open class GestorElementos<T:ElementoBiblioteca>{
    val listaDeElementos = mutableListOf<T>()


    open fun agregarAlCatalogo(elemento:T) {
        this.listaDeElementos.add(elemento)
    }

    open fun eliminarDelCatalogo(elemento:T) {
        val elementoaEliminar = listaDeElementos.find {  it == elemento  }
        if (elementoaEliminar != null){
            listaDeElementos.remove(elementoaEliminar)
        }
    }

    open fun filtrarPorCriterio(elementos: List<T> , criterio: (elemento: T) -> Boolean): List<T>{
        return elementos.filter(criterio)
    }

}

/**
 * catalogo de elementos que tiene la libreria
 */
class Catalogo : GestorElementos<ElementoBiblioteca>() {

    override fun agregarAlCatalogo(elemento: ElementoBiblioteca) {
        super.agregarAlCatalogo(elemento)
    }

    override fun eliminarDelCatalogo(elemento: ElementoBiblioteca) {
        super.eliminarDelCatalogo(elemento)
    }

    override fun filtrarPorCriterio(
        elementos: List<ElementoBiblioteca>,
        criterio: (elemento: ElementoBiblioteca) -> Boolean
    ): List<ElementoBiblioteca> {
        return super.filtrarPorCriterio(elementos, criterio)
    }
}