package umg.edu.gt.prograIII.tree;

public interface InterfazArbol<T extends Comparable<T>> {

    void insertar(T dato);

    boolean existe(T dato);

    T obtener(T dato);

    boolean esHoja();

    boolean esVacio();

    void preOrden();

    void inOrden();

    void postOrden();

    void eliminar(T dato);
}
