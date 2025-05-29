package umg.edu.gt.prograIII.list;

public class Opcion<T> {
    private final T valor;

    public Opcion(T valor) {
        this.valor = valor;
    }

    public boolean estaPresente() {
        return valor != null;
    }

    public T obtener() {
        if (valor == null) {
            throw new IllegalStateException("No hay valor presente");
        }
        return valor;
    }

    public T obtenerO(T otroValor) {
        return valor != null ? valor : otroValor;
    }
}
