package umg.edu.gt.prograIII.tree;

import umg.edu.gt.prograIII.list.ListaEnlazada;

import java.util.function.Consumer;

public class ArbolBinario<T extends Comparable<T>> implements InterfazArbol<T> {

    private T valor;
    private ArbolBinario<T> izdo, dcho;
    private ArbolBinario<T> padre;

    public ArbolBinario() {
        this.valor = null;
        this.izdo = null;
        this.dcho = null;
        this.padre = null;
    }

    @Override
    public void insertar(T dato) {
        if (valor == null) {
            this.valor = dato;
        } else {
            int cmp = dato.compareTo(valor);
            if (cmp < 0) {
                if (izdo == null) {
                    izdo = new ArbolBinario<>();
                    izdo.padre = this;
                }
                izdo.insertar(dato);
            } else if (cmp > 0) {
                if (dcho == null) {
                    dcho = new ArbolBinario<>();
                    dcho.padre = this;
                }
                dcho.insertar(dato);
            } else {
            }
        }
    }

    @Override
    public boolean existe(T dato) {
        if (valor == null) {
            return false;
        }
        int cmp = dato.compareTo(valor);
        if (cmp == 0) {
            return true;
        } else if (cmp < 0) {
            return izdo != null && izdo.existe(dato);
        } else {
            return dcho != null && dcho.existe(dato);
        }
    }

    @Override
    public T obtener(T dato) {
        if (valor == null) return null;
        int cmp = dato.compareTo(valor);
        if (cmp == 0) return valor;
        if (cmp < 0) return izdo != null ? izdo.obtener(dato) : null;
        else return dcho != null ? dcho.obtener(dato) : null;
    }

    @Override
    public boolean esHoja() {
        return valor != null && izdo == null && dcho == null;
    }

    @Override
    public boolean esVacio() {
        return valor == null;
    }

    @Override
    public void preOrden() {
        if (valor != null) {
            System.out.println(valor);
            if (izdo != null) izdo.preOrden();
            if (dcho != null) dcho.preOrden();
        }
    }

    @Override
    public void inOrden() {
        if (valor != null) {
            if (izdo != null) izdo.inOrden();
            System.out.println(valor);
            if (dcho != null) dcho.inOrden();
        }
    }

    @Override
    public void postOrden() {
        if (valor != null) {
            if (izdo != null) izdo.postOrden();
            if (dcho != null) dcho.postOrden();
            System.out.println(valor);
        }
    }

    @Override
    public void eliminar(T dato) {
        if (valor == null) return;

        int cmp = dato.compareTo(valor);

        if (cmp < 0) {
            if (izdo != null) izdo.eliminar(dato);
        } else if (cmp > 0) {
            if (dcho != null) dcho.eliminar(dato);
        } else {
            eliminarNodo();
        }
    }

    private void eliminarNodo() {
        if (izdo != null && dcho != null) {
            // Nodo con dos hijos: encontrar sucesor (mínimo en subárbol derecho)
            ArbolBinario<T> sucesor = dcho.obtenerMinimoNodo();
            valor = sucesor.valor;
            sucesor.eliminarNodo();
        } else if (izdo != null) {
            reemplazarNodo(izdo);
        } else if (dcho != null) {
            reemplazarNodo(dcho);
        } else {
            reemplazarNodo(null);
        }
    }

    private void reemplazarNodo(ArbolBinario<T> nuevoNodo) {
        if (padre != null) {
            if (this == padre.izdo) {
                padre.izdo = nuevoNodo;
            } else {
                padre.dcho = nuevoNodo;
            }
            if (nuevoNodo != null) {
                nuevoNodo.padre = padre;
            }
        } else {

            if (nuevoNodo != null) {
                this.valor = nuevoNodo.valor;
                this.izdo = nuevoNodo.izdo;
                this.dcho = nuevoNodo.dcho;
                if (izdo != null) izdo.padre = this;
                if (dcho != null) dcho.padre = this;
            } else {
                this.valor = null;
                this.izdo = null;
                this.dcho = null;
            }
        }
    }

    private ArbolBinario<T> obtenerMinimoNodo() {
        return izdo == null ? this : izdo.obtenerMinimoNodo();
    }

    public int altura() {
        if (valor == null) return 0;
        int alturaIzq = (izdo != null) ? izdo.altura() : 0;
        int alturaDer = (dcho != null) ? dcho.altura() : 0;
        return Math.max(alturaIzq, alturaDer) + 1;
    }

    public int contarNodos() {
        if (valor == null) return 0;
        int izq = (izdo != null) ? izdo.contarNodos() : 0;
        int der = (dcho != null) ? dcho.contarNodos() : 0;
        return izq + der + 1;
    }

    public void recorrerInOrden(Consumer<T> accion) {
        if (valor != null) {
            if (izdo != null) izdo.recorrerInOrden(accion);
            accion.accept(valor);
            if (dcho != null) dcho.recorrerInOrden(accion);
        }
    }

    public ListaEnlazada<T> inOrdenLista() {
        ListaEnlazada<T> resultado = new ListaEnlazada<>();
        recorrerInOrden(resultado::agregar);
        return resultado;
    }
}
